import java.util.*;
import java.io.*;


class Main{

    static int M, N, H;
    static int[][][] box = null;

    static int[] ii = new int[]{1, -1, 0, 0, 0, 0};
    static int[] jj = new int[]{0, 0, 1, -1, 0, 0};
    static int[] kk = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H+2][N+2][M+2];
        Queue<Triple> queue = new LinkedList<>();
        
        for(int i = 1; i<=H; i++){
            for(int j = 1; j<=N; j++){
                st = new StringTokenizer(bf.readLine());
                for(int k = 1; k<=M; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        queue.offer(new Triple(i, j, k, 0));
                    } 
                }
            }
        }
        // END OF INIT
        int time = 0;
        while(!queue.isEmpty()){
            Triple cur = queue.poll();
            if(time < cur.t) time = cur.t;
            for(int s = 0; s<6; s++){
                int new_i = cur.i + ii[s];
                int new_j = cur.j + jj[s];
                int new_k = cur.k + kk[s];
                if(new_i < 1 || H < new_i || new_j < 1 || N < new_j || new_k < 1 || M < new_k)
                    continue;
                if(box[new_i][new_j][new_k] == 0){
                    box[new_i][new_j][new_k] = 1;
                    queue.offer(new Triple(new_i, new_j, new_k, cur.t+1));
                }
            }
        }
        int ok = 1;
        OUTTER: for(int i = 1; i<=H; i++){
            for(int j = 1; j<=N; j++){
                for(int k = 1; k<=M; k++){
                    if(box[i][j][k] == 0){
                        ok = 0;
                        break OUTTER;
                    }
                }
            }
        }
        if(ok == 1)
            System.out.println(time);
        else
            System.out.println(-1);
    }
}

class Triple{
    int i, j, k, t;
    Triple(int i, int j, int k, int t){
        this.i = i;
        this.j = j;
        this.k = k;
        this.t = t;
    }

}
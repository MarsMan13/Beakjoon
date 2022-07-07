import java.util.*;
import java.io.*;


class Main{

    static int H, W;
    static int[][] map = null;
    static int[] ii = new int[]{1, -1, 0, 0};
    static int[] jj = new int[]{0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        H = Integer.parseInt(st.nextToken());   W = Integer.parseInt(st.nextToken());
        map = new int[H+2][W+2];
        int[][] times = new int[H+2][W+2];
        for(int i = 1; i<=H; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                times[i][j] = 10000;
            }
        }
        Queue<Triple> queue = new LinkedList<>();
        queue.offer(new Triple(1, 1, 0)); 
        // 
        while(!queue.isEmpty()){
            Triple cur = queue.poll();
            for(int s = 0; s<4; s++){
                int new_i = cur.i + ii[s];
                int new_j = cur.j + jj[s];
                // ABOUT AIR
                if(map[new_i][new_j] == 0 && cur.k < times[new_i][new_j]){
                    times[new_i][new_j] = cur.k;
                    queue.offer(new Triple(new_i, new_j, cur.k));
                }
                // ABOUT CHEEZE
                else if(cur.k + 1 < times[new_i][new_j]){
                    times[new_i][new_j] = cur.k + 1;
                    queue.offer(new Triple(new_i, new_j, cur.k+1));
                }
            }
        }
        int[] count = new int[101];
        for(int i = 1; i<=H; i++){
            for(int j = 1; j<=W; j++){
                if(map[i][j] == 1)
                    count[times[i][j]]++;
            }
        } 
        for(int i = 100; 0<=i; i--){
            if(count[i] != 0){
                System.out.println(i);
                System.out.println(count[i]);
                break;
            }
        }
    }
}

class Triple{
    int i, j, k;
    Triple(int i, int j, int k){
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
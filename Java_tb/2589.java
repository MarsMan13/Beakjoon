import java.util.*;
import java.io.*;

class Main {

    static int H, W;
    static int[][] map = null;
    static int[][] visited = null;

    static int[] hh = new int[] { 1, -1, 0, 0 };
    static int[] ww = new int[] { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H + 2][W + 2];

        for (int i = 1; i <= H; i++) {
            String aline = bf.readLine();
            for (int j = 1; j <= W; j++) {
                if (aline.charAt(j - 1) == 'L')
                    map[i][j] = 1;
            }
        }
        // END OF INIT
        int answer = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (map[i][j] == 1) {
                    visited = new int[H + 2][W + 2];
                    visited[i][j] = 1;
                    Queue<Pair> queue = new LinkedList<>();
                    queue.offer(new Pair(i, j, 0));
                    while(!(queue.isEmpty())){
                        Pair curPair = queue.poll();
                        if(answer < curPair.time)  
                            answer = curPair.time;
                        for(int k = 0; k<4; k++){
                            int new_i = curPair.i + hh[k];
                            int new_j = curPair.j + ww[k];
                            if(map[new_i][new_j] == 1 && visited[new_i][new_j] == 0){
                                visited[new_i][new_j] = 1;
                                queue.offer(new Pair(new_i, new_j, curPair.time + 1));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
    
class Pair {
    int i, j;
    int time;

    Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }

    @Override
    public String toString(){
        return "i: "+i+", j: "+j+", time: "+time;
    }
}
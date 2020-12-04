import java.util.*;
import java.io.*;


class Main{

    static int N = 6;
    static int[][] input = new int[N+2][N+2];
    static int[][] visited = new int[N+2][N+2];

    static int[] position = new int[N+1];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=N; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<=N+1; i++){
            visited[i][0] = 1;
            visited[i][N+1] = 1;
            visited[0][i] = 1;
            visited[N+1] = 1;
        }
        def1();
    }
    // index : 1 ~ 6, 
    static int def1(int i, int j, int index, int direction){
        int[] xx = new int[]{1, -1, 0, 0};
        int[] yy = new int[]{0, 0, 1, -1};
        for(int k = 0; k<4; k++){
            if(visited[i+xx[k]][j+yy[k]] == 0 || input[i+xx[k]][j+yy[k]] != 0){
                visited[i+xx[k]][j+yy[k]] = 1;
                
                def1(i+xx[k], j+yy[k]);

            }
        }
    }
}
import java.util.*;
import java.io.*;


class Main{

    static int N;
    static int[][][] map = null;
    static int[][] visited = null;
    static int[] ii = new int[]{1, -1, 0, 0};
    static int[] jj = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[2][N+2][N+2];
        for(int i = 1; i<=N; i++){
            String line = bf.readLine();
            for(int j = 1; j<=N; j++){
                map[0][i][j] = line.charAt(j-1);
                map[1][i][j] = (line.charAt(j-1) == 'B' ? 'B' : 'R');
            }
        }
        // END OF INIT
        for(int k = 0; k<2; k++){
            int count = 0;
            visited = new int[N+2][N+2];
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if(visited[i][j] == 0){
                        count++;
                        dfs(k, i, j, map[k][i][j]);
                    }
                }
            }
            System.out.print(count);
            if(k == 0)  System.out.print(" ");
        }
    }

    public static void dfs(int t, int i, int j, int c){
        visited[i][j] = 1;
        for(int k = 0; k<4; k++){
            int new_i = i + ii[k];
            int new_j = j + jj[k];
            if(map[t][new_i][new_j] == c && visited[new_i][new_j] == 0){
                dfs(t, new_i, new_j, c);
            }
        }
    }
}

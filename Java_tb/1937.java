import java.util.*;
import java.io.*;


class Main{

    static int n = 0;
    static int[][] map = null;
    static int[][] bestAt = null;
    static int[][] visited = null;

    static int[] xx = new int[]{0,0,1,-1};
    static int[] yy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+2][n+2];
        visited = new int[n+2][n+2];
        bestAt = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        // END OF INIT-------------------------------------------------------------

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(bestAt[i][j] == 0){
                    visited[i][j] = 1;
                    bestAt[i][j] = dfs(i, j);
                    visited[i][j] = 0;
                }
            }
        }

        int max = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(max < bestAt[i][j])
                    max = bestAt[i][j];
            }
        }
        System.out.println(max);
    }


    static int dfs(int x, int y){
        int max = 1;

        if(bestAt[x][y] != 0){
            visited[x][y] = 0;
            return bestAt[x][y];
        }

        for(int i = 0; i<4; i++){
            if(x + xx[i] == 0 || y + yy[i] == 0 || x + xx[i] == n+1 || y+yy[i] == n+1){
                continue;
            }
            if(visited[x+xx[i]][y+yy[i]] == 0 && map[x][y] < map[x+xx[i]][y+yy[i]]){
                visited[x+xx[i]][y+yy[i]] = 1;
                int maxTemp = dfs(x+xx[i], y+yy[i])+1;
                if(max < maxTemp){
                    max = maxTemp;
                }
            }
        }
        bestAt[x][y] = max;
        visited[x][y] = 0;
        return bestAt[x][y];
    }

}


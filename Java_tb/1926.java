import java.util.*;
import java.io.*;


class Main{

    static int[] ii = new int[]{1,-1,0,0};
    static int[] jj = new int[]{0,0,1,-1};
    static int[][] map = null;
    static int[][] visited = null;
    static int n, m;
    public static void main(String[] args) throws IOException{


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());   m = Integer.parseInt(st.nextToken());
        map = new int[n+2][m+2];
        visited = new int[n+2][m+2];
        //
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //
        int max = 0;
        int count = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(map[i][j] == 1 && visited[i][j] == 0){
                    count++;
                    int tempMax = dfs(i, j);
                    if(max < tempMax)
                        max = tempMax;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static int dfs(int i, int j){
        visited[i][j] = 1;
        int sum = 1;
        for(int k = 0; k<4; k++){
            int new_i = i + ii[k];
            int new_j = j + jj[k];
            if(map[new_i][new_j] == 1 && visited[new_i][new_j] == 0){
                sum += dfs(new_i, new_j);
            }
        }
        return sum;
    }
}
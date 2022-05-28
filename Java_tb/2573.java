import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static int M = 0;
    static int[][] input = null;
    static int[][] visited = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N+2][M+2];
        visited = new int[N+2][M+2];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=M; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // END OF INIT

        int count = 1;
        while(true){
            int tempCount = 0;
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=M; j++){
                    if(input[i][j] != 0 && visited[i][j] == 0){
                        visited[i][j] = 1;
                        def1(i, j);
                    }
                }
            }
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=M; j++){
                    if(input[i][j] == -1){
                        input[i][j] = 0;
                    }
                    visited[i][j] = 0;
                }
            }
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=M; j++){
                    if(input[i][j] > 0 && visited[i][j] == 0){
                        tempCount++;
                        visited[i][j] = 1;
                        def2(i, j);
                    }
                }
            }
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=M; j++){
                    visited[i][j] = 0;
                }
            }
            if(tempCount >= 2){
                System.out.println(count);
                break;
            }
            if(tempCount == 0){
                System.out.println(0);
                break;
            }
            count++;
        }
    }

    static void def2(int i, int j){
        for(int k = 0; k<4; k++){
            if(0 < input[i+xx[k]][j+yy[k]] && visited[i+xx[k]][j+yy[k]] == 0){
                visited[i+xx[k]][j+yy[k]] = 1;
                def2(i+xx[k], j+yy[k]);
            }
        }
    }

    static int[] xx = {1, -1, 0, 0};
    static int[] yy = {0, 0, 1, -1};
    static int def1(int i, int j){
        int minor = 0;
        for(int k = 0; k<4; k++){
            if(input[i+xx[k]][j+yy[k]] == 0){
                minor++;
            }
            else if(0 < input[i+xx[k]][j+yy[k]] && visited[i+xx[k]][j+yy[k]] == 0){
                visited[i+xx[k]][j+yy[k]] = 1;
                def1(i+xx[k], j+yy[k]);
            }
        }
        input[i][j] -= minor;
        if(input[i][j] <= 0){
            input[i][j] = -1;
        }
        return 0;
    }
}

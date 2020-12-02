import java.util.*;
import java.io.*;



class Main{

    static int N = 0;
    static int[][] input = null;

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new int[N+1][N+1];
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(from == -1 && to == -1)
                break;
            input[from][to] = input[to][from]= 1;
        }
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i == j){
                    input[i][j] = 0;
                }
                else if(input[i][j] == 0){
                    input[i][j] = 1000;
                }
            }
        }


        // END OF INIT
        Floyd_Washall();
    }

    static int Floyd_Washall(){
        
        int[][] result = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                result[i][j] = input[i][j];
            }
        }
        //
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    if(result[i][k]+result[k][j] < result[i][j]){
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }
        
        // END OF PROCESS

        int min = -1;
        int count = 0;
        List<Integer> men = new ArrayList<>();
        for(int i = 1; i<=N; i++){
            int max = -1;
            for(int j = 1; j<=N; j++){
                if(max == -1 || max<result[i][j]){
                    max = result[i][j];
                }
            }
            if(min == -1){
                min = max;
                count++;
                men.add(i);
            }
            else if(max == min){
                count++;
                men.add(i);
            }
            else if(max < min){
                min = max;
                count = 1;
                men = new ArrayList<>();
                men.add(i);
            }
        }
        System.out.println(min+" "+count);
        Collections.sort(men);
        for(Integer i : men){
            System.out.print(i+" ");
        }

        return 0;
    }
}
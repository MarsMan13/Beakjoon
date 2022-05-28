import java.util.*;
import java.io.*;


class Main{

    static int N;
    static int K;
    static int[] input = null;
    static int[][] dp = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); 
        }
        input = new int[N];
        dp = new int[N][K];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<K; j++)
                dp[i][j] = -1;
        }
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(input);
        // END OF INIT

        System.out.println(def1(K, N-1));

    }

    static int def1(int n, int index){

        if(dp[index][n-1] != -1){
            return dp[index][n-1];
        }

        int ret = 0;
      
        for(int i = index; 0<=i; i--){
            if(0 < n-input[i]){
                ret += def1(n-input[i], i);
            }
            else if(n-input[i] == 0)
                ret++;
        }

        return dp[index][n-1] = ret;
    }
}
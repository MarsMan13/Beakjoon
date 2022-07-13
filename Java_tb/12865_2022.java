import java.util.*;
import java.io.*;
/*
 * 
 * dp[i][w] =   dp[i-1][w]                                      : i-th item is not selected.                                     
 *              or
 *              vs[i] + dp[i-1][w-ws[i]]    (if (w > ws[i]) )   : i-th item is selected. 
 * 
 * 
 * 
 * 
 */
class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ws = new int[N+1];
        int[] vs = new int[N+1];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ws[i] = w; vs[i] = v;
        }
        int[][] dp = new int[N+1][K+1];
        for(int w = 1; w<=K; w++){
            for(int i = 1; i<=N; i++){
                dp[i][w] = dp[i-1][w];
                if(0 <= w - ws[i] && vs[i] + dp[i-1][w-ws[i]] > dp[i][w])
                    dp[i][w] = vs[i] + dp[i-1][w-ws[i]];
            }
        }
        int max = 0;
        for(int i = 1; i<=N; i++){
            if(max < dp[i][K])
                max = dp[i][K];
        }
        System.out.println(max);
    }
}
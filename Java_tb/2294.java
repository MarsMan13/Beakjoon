import java.util.*;
import java.io.*;


class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }
        // END OF INIT
        int[] dp = new int[k+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i<=k; i++){
            for(int c : coins){
                if(c <= i && dp[i - c] != -1){
                    dp[i] = Math.max(dp[i], dp[i-c]+1);
                }
            }
        } 
        System.out.println(dp[k]);
    }
}
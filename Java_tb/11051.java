import java.util.*;
import java.io.*;


class Main{
	
	static int[][] dp = new int[1001][1001];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i<=N; i++){
			for(int j = 0; j<=K; j++)
				dp[i][j] = -1;
		}
		System.out.println(def(N, K));
	}
	
	public static int def(int n, int k){
		if(dp[n][k] != -1)	return dp[n][k];
		if(n == k || k == 0)	return dp[n][k] = 1;
		return dp[n][k] = (def(n-1, k) + def(n-1, k-1))%10007;
		
	}
}
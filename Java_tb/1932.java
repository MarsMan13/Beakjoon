import java.util.*;
import java.io.*;



class Main{
	
	static int n = 0;
	static int[][] floor = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		floor = new int[n+1][n+1];
		for(int i = 1; i<=n; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=i; j++){
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// END OF INIT
		int[][] dp = new int[n+1][n+1];
		for(int j = 1; j<=n; j++){
			dp[n][j] = floor[n][j];
		}
		for(int i = n-1; 0<i; i--){
			for(int j = 1; j<=i; j++){
				dp[i][j] = dp[i+1][j];
				if(dp[i+1][j] < dp[i+1][j+1])
					dp[i][j] = dp[i+1][j+1];
				dp[i][j] += floor[i][j];
			}
		}
		System.out.println(dp[1][1]);
	}
}
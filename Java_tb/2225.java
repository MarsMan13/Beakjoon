import java.util.*;
import java.io.*;


class Main{
	
	static final long DIV = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());	int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[201][201];	
		for(int j = 0; j<=N; j++){
			dp[1][j] = 1;
		}
		//
		for(int i = 2; i<=K; i++){
			for(int j = 0; j<=N; j++){
				long tempSum = 0;
				for(int k = 0; k<=j; k++){
					tempSum = (tempSum + dp[i-1][j - k])%DIV;
				}
				dp[i][j] = tempSum;
			}
		}
		System.out.println(dp[K][N]);
	}
}
import java.util.*;

class Main{
	
	static final long DIV = 1000000003L;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	int K = sc.nextInt();	sc.close();
		long[][] dp = new long[K+1][N+1];
		for(int j = 1; j<=N; j++)	dp[1][j] = j;
		for(int i = 2; i<=K; i++){
			for(int j = 1; j<=N; j++){
				if(j != N && 0<=j-2)
					dp[i][j] =(0L + dp[i][j] + dp[i-1][j-2])%DIV;
				else if(j == N && 0<=j-3)
					dp[i][j] =(0L + dp[i][j] + dp[i-1][j-3])%DIV;
				dp[i][j] = (0L + dp[i][j] + dp[i][j-1])%DIV;
			}
		}
		System.out.println(dp[K][N]);
	}
}
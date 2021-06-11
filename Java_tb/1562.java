import java.util.*;


class Main{
	
	static int[][] dp = null;
	static final int INF = 1000000000;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int[10][N+1];
		
		for(int i = 1; i<10; i++)	dp[i][1] = 1;
		//
		for(int j = 2; j<=N; j++){
			for(int i = 0; i<10; i++){
				int tempSum = 0;
				if(0 <= i-1)
					tempSum = (tempSum + dp[i-1][j-1]) % INF;
				if(i+1 < 10)
					tempSum = (tempSum + dp[i+1][j-1]) % INF;
				//
				dp[i][j] = tempSum;	
			}
		}
		int sum = 0;
		for(int i = 1; i<10; i++)
			sum = (sum + dp[i][N])%INF;
		// PROCESS ABOUT ALL
		
		for(int j = 2; j<=N; j++){
			for(int i = 0; i<10; i++){
				int tempSum = 0;
				if(0 <= i-1)
					tempSum = (tempSum + dp[i-1][j-1]) % INF;
				if(i+1 < 10)
					tempSum = (tempSum + dp[i+1][j-1]) % INF;
				//
				dp[i][j] = tempSum;	
			}
		}
		int sum = 0;
		for(int i = 1; i<10; i++)
			sum = (sum + dp[i][N])%INF;
		
	}
}
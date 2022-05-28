import java.util.*;


class Main{
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	sc.close();
		
		long[] dp = new long[N+1];
		dp[1] = 1L;	
		for(int i = 2; i<=N; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
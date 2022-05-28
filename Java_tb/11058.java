import java.util.*;


class Main{
		
	static long[] dp = null;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	sc.close();
		dp = new long[N+1];	Arrays.fill(dp, 0L);
		dp[1] = 1L;
		for(int i = 2; i<=N; i++){
			if(dp[i] < dp[i-1] + 1)
				dp[i] = dp[i-1] + 1L;
			long buffer = dp[i];
			long temp = dp[i];
			for(int j = i+3; j<=N; j++){
				temp = temp + buffer;
				if(dp[j] < temp)
					dp[j] = temp;
			}
		}
		System.out.println(dp[N]);
	}
}

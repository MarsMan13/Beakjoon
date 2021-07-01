import java.util.*;


class Main{
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	sc.close();
		
		int[] dp = new int[N+1];	dp[1] = 1;
		dp[0] = 1;	
		for(int i = 2; i<=N; i++){
			dp[i] += (dp[i-2] * 2);
			dp[i] += dp[i-1];
		}
		//
		int tot = dp[N];
		int symmetry = dp[N/2];
		if(N%2 == 0)
			symmetry += dp[N/2-1] * 2;
		int result = (tot - symmetry)/2 + symmetry;
		
		System.out.println(result);
	}
}
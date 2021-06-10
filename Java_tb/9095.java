import java.util.*;

class Main{
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] dp = new int[12];	Arrays.fill(dp, 0);	dp[0] = 1;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int n = sc.nextInt();
			for(int i = 1; i<=n; i++){
				if(dp[i] != 0)
					continue;
				if(0<=i-1){
					dp[i] += dp[i-1];
				}
				if(0<=i-2){
					dp[i] += dp[i-2];
				}
				if(0<=i-3){
					dp[i] += dp[i-3];
				}
			}
			sb.append(dp[n]);	sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
import java.util.*;
import java.math.*;

class Main{
	
	static BigInteger[][] dp = null;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		
		dp = new BigInteger[n+1][n+1];
		for(int i = 1; i<=n; i++)
			dp[i][0] = dp[i][i] = new BigInteger("1");
		System.out.println(def(n, m));
	}
	
	public static BigInteger def(int n, int m){
		if(dp[n][m] != null)
			return dp[n][m];
		return dp[n][m] = def(n-1, m-1).add(def(n-1, m));
	}
}
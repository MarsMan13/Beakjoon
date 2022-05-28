import java.util.*;
class Main{
	static long[] dp = new long[91];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Arrays.fill(dp, -1L);
		dp[0]=0L;dp[1]=1L;
		System.out.println(def(n));sc.close();
	}
	public static long def(int i){
		if(dp[i] != -1)
			return dp[i];
		return dp[i] = 0L + def(i-1) + def(i-2);
	}
}
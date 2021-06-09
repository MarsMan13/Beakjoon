import java.util.*;

class Main{
	static int[] dp = new int[1000001];
	static final int MAX = 100000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();Arrays.fill(dp, MAX);
		def(N, 0);
		System.out.println(dp[1]);sc.close();
	}
	
	public static int def(int n, int count){
		
		if(n == 1)
			return dp[n] = count;
		
		if(dp[n] != MAX)
			return dp[n];
		
		int temp1, temp2, temp3;
		temp1 = temp2 = temp3 = MAX;
		if(n%3 == 0){
			return temp1 = def(n/3, count+1);
		}
		if(n%2 == 0){
			return temp2 = def(n/2, count+1);
		}
		if(0 < n-1){
			return temp3 = def(n-1, count+1);
		}
		return dp[n] = Math.min(temp1, Math.min(temp2, temp3));
	}
}
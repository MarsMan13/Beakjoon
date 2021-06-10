import java.util.*;

class Main{
	static int[] dp = new int[1000001];
	static final int MAX = 100000000;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();Arrays.fill(dp, MAX);
		
		def(N, 0);
		System.out.println(dp[1]);
		sc.close();	
	}
	
	public static void def(int n, int count){
		
		
		if(count < dp[n])
			dp[n] = count;
		else
			return;
		
		if(n%3 == 0 && 0<(n/3) && count+1 < dp[1]){
			def(n/3, count+1);
		}
		if(n%2 == 0 && 0<(n/2) && count+1 < dp[1]){
			def(n/2, count+1);
		}
		if(0 < n-1 && count+1 < dp[1]){
			def(n-1, count+1);
		}
	
	}
}
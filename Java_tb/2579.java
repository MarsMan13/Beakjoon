import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[] input = null;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		input = new int[N+1];
		dp = new int[N+1];
		
		for(int i = 1; i<=N; i++)
			input[i] = Integer.parseInt(bf.readLine());
		//
		System.out.println(def(N));
		
	}
	
	public static int def(int n){
		
		if(dp[n] != 0 || n == 0)
			return dp[n];
		
		int ret1 = input[n];
		int ret2 = input[n];
		if(0<=n-1){
			ret1 += input[n-1];
			if(0<=n-3)
				ret1 += def(n-3);
			
		}
		if(0<=n-2){
			ret2 += def(n-2);
		}
		return dp[n] = Math.max(ret1, ret2);
	}
}
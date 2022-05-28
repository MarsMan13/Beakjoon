import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] input = new int[n+3];
		for(int i = 3; i<n+3; i++){
			st = new StringTokenizer(bf.readLine());
			input[i] = Integer.parseInt(st.nextToken());
		}
		//
		int[] dp = new int[n+3];
		for(int i = 3; i<n+3; i++){
			int ret1 = dp[i-3] + input[i-1] + input[i];
			int ret2 = dp[i-2] + input[i];
			int ret3 = dp[i-1];
			dp[i] = Math.max(ret1, Math.max(ret2, ret3));
		}
		System.out.println(dp[n+2]);
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[] input = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		//
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		//
	
		int[] dp = new int[N+1];
	
		int max = -1;
		for(int i = 1; i<=N; i++){
			int longest = 0;
			for(int j = 1; j<=i-1; j++){
				if(input[j] > input[i] && longest < dp[j]){
					longest = dp[j];
				}
			}
			dp[i] = longest + 1;
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
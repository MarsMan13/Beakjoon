import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[] input = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		// END OF INIT
		
		long[][] dp = new long[N][21];	// v: 0 -> index : 20;
		dp[0][input[0]] = 1;
		
		for(int i = 1; i<N-1; i++){
			for(int j = 0; j<=20; j++){
				if(0 <= j-input[i] && j-input[i] <= 20)
					dp[i][j] += dp[i-1][j-input[i]];
				if(0 <= j+input[i] && j+input[i] <= 20)
					dp[i][j] += dp[i-1][j+input[i]];
			}
		}
		System.out.println(dp[N-2][input[N-1]]);
	}
}




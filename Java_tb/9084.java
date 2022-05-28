import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			int maxValue = -1;
			// input1 : The number of coins
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			// input2 : usable coins
			st = new StringTokenizer(bf.readLine());
			int[] coins = new int[N+1];
			for(int i = 1; i<=N; i++){
				coins[i] = Integer.parseInt(st.nextToken());
				if(maxValue < coins[i])	maxValue = coins[i];
			}
			// input3 : target
			st = new StringTokenizer(bf.readLine());
			int target = Integer.parseInt(st.nextToken());
			if(maxValue < target)	maxValue = target;
			// END OF INIT
			
			int[][] dp = new int[N+1][maxValue+1];
			for(int i = 1; i<=N; i++)	dp[i][coins[i]] = 1;
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=target; j++){
					dp[i][j] += dp[i - 1][j];
					if(0 <= j - coins[i])
						dp[i][j] += dp[i][j - coins[i]];
				}
			}
			sb.append(dp[N][target]);	sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
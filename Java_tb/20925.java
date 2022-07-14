import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] cs = new int[N+1];
		int[] es = new int[N+1];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			int c = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			cs[i] = c;
			es[i] = e;
		}	
		int[][] costTime = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				costTime[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// END OF INIT
		/*
		 * dp[t][i] = 
		 * 	Max(
		 * 		dp[t - 1][j] + e_i 	(if i == j, c_i <= dp[t - 1][i]),
		 *  	dp[t - t_ji][j] 	(if i != j, c_i <= dp[t - t_ji][j])
		 * 	)
		 */
		int max = 0;
		int[][] dp = new int[T+1][N+1];
		for(int t = 1; t<=T; t++){
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=N; j++){
					if(i == j && cs[i] <= dp[t-1][i]){
						dp[t][i] = Math.max(dp[t][i], dp[t-1][i] + es[i]);
					}
					else if(0 <= t - costTime[j][i] && cs[i] <= dp[t-costTime[j][i]][j]){
						dp[t][i] = Math.max(dp[t][i], dp[t-costTime[j][i]][j]);
					}
				}
				max = Math.max(max, dp[t][i]);
			}
		}
		System.out.println(max);
	}
}
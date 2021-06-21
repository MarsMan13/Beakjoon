import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			//
			int[] input = new int[N+1];
			int[] sum = new int[N+1];
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=N; i++){
				input[i] = Integer.parseInt(st.nextToken());
				sum[i] += sum[i-1] + input[i];
			}	
			// END OF INIT
			int[][] dp = new int[N+1][N+1];
			for(int i = 1; i<=N; i++)
				dp[i][i] = input[i];
			for(int step = 1; step < N; step++){
				int i = 1;	int j = 1 + step;
				while(i<=N && j<=N){
					int ret1 = input[i] + (sum[j] - sum[i]) - dp[i+1][j];
					int ret2 = input[j] + (sum[j-1] - sum[i-1]) - dp[i][j-1];
					dp[i][j] = Math.max(ret1, ret2);
					i++;j++;
				}
			}
			sb.append(dp[1][N]);	sb.append("\n"); 
		}
		System.out.print(sb.toString());
	}
}
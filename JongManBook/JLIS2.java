import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());	int m = Integer.parseInt(st.nextToken());
			int[] input1 = new int[n+1];	int[] input2 = new int[m+1];
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=n; i++)
				input1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=m; i++)
				input2[i] = Integer.parseInt(st.nextToken());
			
			// END OF INIT
			int[][] dp = new int[n+1][m+1];
			dp[1][0] = dp[0][1] = 1;
			int result = Integer.MIN_VALUE;
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=m; j++){
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(input1[i-1] < input1[i] && input1[i] != input2[j])
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+1);
					if(input2[j-1] < input2[j] && input2[j] != input1[i])
						dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+1);
					result = Math.max(result, dp[i][j]);
				}
			}
			// END OF PROCESS
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
}
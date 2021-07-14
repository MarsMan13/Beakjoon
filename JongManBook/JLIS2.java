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
			for(int i = 1; i<=n; i++)	dp[i][0] = 1;
			for(int j = 1; j<=m; j++)	dp[0][j] = 1;
			int result = 0;
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=m; j++){
					// about input1
					dp[i][j] = 1;
					if(input1[i] == input2[j])	dp[i][j] = dp[i-1][j];
					else{
						for(int ii = i-1; 0<=ii; ii--){
							if(input1[ii] < input1[i])
								dp[i][j] = Math.max(dp[i][j], dp[ii][j] + 1);
						}
						for(int jj = j-1; 0<=jj; jj--){
							if(input2[jj] < input2[j])
								dp[i][j] = Math.max(dp[i][j], dp[i][jj] + 1);
							
						}
					}
					if(result < dp[i][j])	result = dp[i][j];
				}
			}
			System.out.println("\n======");
			for(int i = 0; i<=n; i++){
				for(int j = 0; j<=m; j++){
					System.out.printf("%2d ", dp[i][j]);
				}
				System.out.println();
			}
			// END OF PROCESS
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
}
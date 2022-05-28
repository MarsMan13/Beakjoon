import java.util.*;
import java.io.*;


class Main{
	
	static int n = 0;
	static int[][] input = new int[1][1];
	static int[][] dp = new int[1][1];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			n = Integer.parseInt(bf.readLine());
			input = new int[n+1][n+1];
			dp = new int[n+1][n+1];
		
			for(int i = 1; i<=n; i++){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 1; j<=i; j++)	input[i][j] = Integer.parseInt(st.nextToken());
			}
			// END OF INIT
			sb.append(def(1, 1));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int i, int j){
		if(i == n)
			return input[i][j];
		// END OF BASE CASE
		if(dp[i][j] != 0)	return dp[i][j];
		return dp[i][j] = Math.max(def(i+1, j), def(i+1, j+1)) + input[i][j];
		
	}
}
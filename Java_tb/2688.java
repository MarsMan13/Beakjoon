import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int n = Integer.parseInt(bf.readLine());
			//
			long[][] dp = new long[n+1][10];
			for(int j = 0; j<10; j++)	dp[1][j] = 1L;
			for(int i = 2; i<=n; i++){
				for(int j = 0; j<10; j++){
					for(int k = j; k<10; k++){
						dp[i][j] += dp[i-1][k];
					}
				}
			}
			long ret = 0;
			for(int j = 0; j<10; j++)
				ret += dp[n][j];
			sb.append(ret);	sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
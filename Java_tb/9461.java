import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		long[] dp = new long[101];
		dp[1] = 1L;	dp[2] = 1L;	dp[3] = 1L;
		dp[4] = 2L;	dp[5] = 2L;	dp[6] = 3L;
		for(int i = 7; i<=100; i++){
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			sb.append(dp[N]);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}
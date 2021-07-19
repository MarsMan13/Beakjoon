import java.util.*;
import java.io.*;

class Main{
	
	static final int DIV = 1000000007;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int N = sc.nextInt();
			
			int[] dp = new int[N+1];	
			dp[0] = dp[1] = 1;	dp[2] = 2;
			for(int i = 3; i<=N; i++){
				dp[i] = (dp[i-1] + dp[i-2])%DIV;
			}
			if(N%2 == 0){
				long result = (0L + dp[N] + DIV + DIV - dp[N/2] - dp[N/2 - 1])%DIV;
				sb.append(result);	sb.append("\n");
			}
			else{	// == 1
				long result = (0L + dp[N] + DIV - dp[N/2])%DIV;
				sb.append(result);	sb.append("\n");
			}
			
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
		
	}
}
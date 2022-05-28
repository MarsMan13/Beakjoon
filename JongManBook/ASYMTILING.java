import java.util.*;
import java.io.*;


class Main{
	
	static int n = 0;
	static int[] dp = null;
	static final int DIV = 1000000007;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			n = Integer.parseInt(bf.readLine());
			dp = new int[n+1];	Arrays.fill(dp, -1);
			
			dp[n] = 1;
			dp[n-1] = 2;
			
			for(int i = n-2; 0<i; i--){
				dp[i] = (dp[i+1] + dp[i+2])%DIV;
			}
			
			long result = 0L;
			if(n % 2 == 0){
				result += ((dp[1] + DIV) - (0L + dp[n/2])%DIV) % DIV;
			}
			else{
				result += ((dp[1] + DIV) - dp[n/2])%DIV;
			}
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}
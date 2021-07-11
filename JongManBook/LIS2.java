import java.util.*;
import java.io.*;


class Main{
	
	static int n = 0;
	static int[] input = new int[1];
	static int[] dp = new int[1];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			n = Integer.parseInt(bf.readLine());
			input = new int[n+1];	dp = new int[n+1];
			input[0] = -100000000;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i = 1; i<=n; i++)	input[i] = Integer.parseInt(st.nextToken());
			sb.append((def(0)-1));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
	
	public static int def(int start){
		if(dp[start] != 0)	return dp[start];
		
		int ret = 0;
		for(int i = start+1; i<=n; i++){
			if(input[start] < input[i])
				ret = Math.max(def(i), ret);
		}
		return dp[start] = ret + 1;
	}
}
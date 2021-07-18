import java.util.*;
import java.io.*;


class Main{
	
	static int n = 0;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			n = Integer.parseInt(bf.readLine());
			dp = new int[n+1];	Arrays.fill(dp, -1);
			sb.append(def(1));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int index){
		if(n+1==index)	return 1;
		if(n < index)	return 0;
		if(dp[index]!= -1)	return dp[index];
		
		int ret = (def(index+2) + def(index+1)) % 1000000007;
		return dp[index] = ret;
	}
}
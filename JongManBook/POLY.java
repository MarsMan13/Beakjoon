import java.util.*;
import java.io.*;


class Main{
	
	static final int DIV = 10000000;
	static int N = 0;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			N = Integer.parseInt(bf.readLine());
			dp = new int[N+1][N+1];
			for(int i = 0; i<=N; i++)
				for(int j = 0; j<=N; j++)
					dp[i][j] = -1;
			//
			sb.append(def(-1, N));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int upperLen, int rest){
		if(rest == 0)	return 1;
		
		if(upperLen != -1)
			if(dp[upperLen][rest] != -1)	return dp[upperLen][rest];
		
		int sum = 0;
		for(int i = 1; i<=rest; i++){
			if(upperLen != -1)
				sum = (sum + (upperLen + i - 1) * def(i, rest-i))%DIV;
			else
				sum = (sum + def(i, rest-i))%DIV;
		}
		if(upperLen != -1)
			return dp[upperLen][rest] = sum;
		return sum;
	}
}
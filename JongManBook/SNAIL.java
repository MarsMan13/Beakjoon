import java.util.*;
import java.io.*;

class Main{

	static int n, m;	
	static double[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());	n = Integer.parseInt(st.nextToken());
			dp = new double[n+1][m+1];
			for(int i = 0; i<=n; i++)
				for(int j = 0; j<=m; j++)
					dp[i][j] = -1.0;
			sb.append(String.format("%.010f" ,def(0, 0)));	sb.append("\n");	
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static double def(int day, int pos){
		if(n < day)		return 0.0;
		if(m <= pos)	return 1.0;
		//
		if(0.0 <= dp[day][pos])	return dp[day][pos];
		
		double ret = (0.75 * def(day+1, pos+2)) + (0.25 * def(day+1, pos+1));
		return dp[day][pos] = ret;
	}
}
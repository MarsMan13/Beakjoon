import java.util.*;
import java.io.*;


class Main{
	
	static int n, d, p;	// number, days, prison
	static int[][] map = null;
	static double[][] dp = null;
	static int[] adjs = null;
	static double[] result = null;
	static int q = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int c = 0; c<T; c++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());	d = Integer.parseInt(st.nextToken());	p = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			adjs = new int[n];
			result = new double[n];
			dp = new double[d+1][n];
			for(int i = 0; i<n; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)	adjs[i]++;
				}
			}
			// PROCESS
			
			int t = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int tt = 0; tt < t; tt++){
				for(int i = 0; i<=d; i++)
					for(int j = 0; j<n; j++)
						dp[i][j] = -1.0;
				q = Integer.parseInt(st.nextToken());
				sb.append(String.format("%.8f", def(0, p)));
				if(tt != t-1)	sb.append(" ");
				else			sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static double def(int day, int index){
		if(day == d){
			if(index == q)	return 1.0;
			return 0.0;
		}
		
		if(dp[day][index] > -0.5)	return dp[day][index];
		
		double ret = 0.0;
		double curPer = 1.0 / adjs[index];
		for(int adj = 0; adj < n; adj++){
			if(map[index][adj] == 0)	continue;
			ret += curPer * def(day+1, adj);
		}
		return dp[day][index] = ret;
	}
}
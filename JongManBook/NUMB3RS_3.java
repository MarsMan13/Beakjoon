import java.util.*;
import java.io.*;


class Main{

	static int n, d, p;	
	static int[][] map = null;
	static double[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int c = 0; c < T; c++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			map = new int[n][n+1];
			dp = new double[d+1][n];
			for(int i = 0; i<=d; i++)
				for(int j = 0; j<n; j++)
					dp[i][j] = -1.0;
			for(int i = 0; i<n; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)	map[i][n]++;
				}
			}
			int t = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int tt = 0; tt<t; tt++){
				int curTarget = Integer.parseInt(st.nextToken());
				sb.append(String.format("%.8f", def(d, curTarget)));
				if(tt != t-1)	sb.append(" ");
				else			sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	
		bf.close();	bw.close();
	}
	
	public static double def(int day, int index){
		if(day == 0){
			if(index == p)	return 1.0 / map[p][n];
			return 0.0;
		}	
		if(dp[day][index] > -0.5)	return dp[day][index];
		//
		double ret = 0.0;
		double per = 1.0 / map[index][n];
		for(int j = 0; j<n; j++){
			if(map[index][j] == 0)	continue;
			double temp = def(day-1, j);
			if(day != d) temp *= per;
			// if(day == d && index == 0)
			// 	System.out.println("temp: "+def(day-1, j));
			ret += temp;
		}
		return dp[day][index] = ret;
	}
}
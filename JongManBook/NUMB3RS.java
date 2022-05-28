import java.util.*;
import java.io.*;


class Main{
	
	static int n, d, p;	// number, days, prison
	static int[][] map = null;
	static int[][] dp = null;
	static int[] adjs = null;
	static double[] result = null;
	
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
			dp = new int[d+1][n];
			for(int i = 0; i<n; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)	adjs[i]++;
				}
			}
			// PROCESS
			def(0, p, 1.0);
			
			int t = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int tt = 0; tt < t; tt++){
				sb.append(String.format("%.8f", result[Integer.parseInt(st.nextToken())]));
				if(tt != t-1)	sb.append(" ");
				else			sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static void def(int day, int index, double curPer){
		if(day == d){
			result[index] += curPer;
			return;
		}
		
		double nextPer = 1.0 / adjs[index] * curPer;
		for(int adj = 0; adj < n; adj++){
			if(map[index][adj] == 0)	continue;
			def(day+1, adj, nextPer);
		}
	}
}
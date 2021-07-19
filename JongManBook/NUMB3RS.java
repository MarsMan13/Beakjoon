import java.util.*;
import java.io.*;


class Main{
	
	static int n, d, p;	// number, days, prison
	static int[][] map = null;
	static int[] adjCnt = null;
	static double[] result = null;
	static int t;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int c = 0; c<T; c++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			adjCnt = new int[n];	result = new double[n];
			for(int i = 0; i<n; i++){
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)	adjCnt[i]++;
				}
			}
			//
			def(0, p);
			//
			int t = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for(int tt = 0; tt < t; tt++){
				sb.append(result[Integer.parseInt(st.nextToken())]);
				if(tt != t-1)	sb.append(" ");
				else			sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static double def(int day, int index){
		if(d == day)	return 1.;
	
		double ret = 0.;
		double per = 1.0 / adjCnt[index];
		for(int adj = 0; adj < n; adj++){
			if(map[index][adj] == 0)	continue;
			ret += per * def(day+1, adj);
		}
		result[index] += ret;
		return ret;
	}
}
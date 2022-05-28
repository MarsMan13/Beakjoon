import java.util.*;
import java.io.*;


class Main{
	
	static int n, m, r;
	static int[] items = null;
	static final int INF = 10000000;
	static int[][] dist = null;
	static int[] result = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		items = new int[n+1];
		result = new int[n+1];
		dist = new int[n+1][n+1];
		for(int i = 1; i<=n; i++){
			items[i] = Integer.parseInt(st.nextToken());
			for(int j = 1; j<=n; j++){
				if(i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}
	
		for(int i = 1; i<=r; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			dist[from][to] = length;
			dist[to][from] = length;
		}
		// END OF INIT

		for(int k = 1; k<=n; k++){
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=n; j++){
					if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		// END OF PROCESS
		
		int max = -1;
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(dist[i][j] <= m)
					result[i] += items[j];
			}
			if(max == -1 || max < result[i])
				max = result[i];
		}
		System.out.println(max);	
	}
}


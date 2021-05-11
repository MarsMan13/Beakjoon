import java.util.*;
import java.io.*;


class Main{
	
	static int n, m;
	static int[][] map = null;
	static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		map = new int[n+1][n+1];
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(i == j)
					map[i][j] = 0;
				else
					map[i][j] = INF;
			}
		}
		
		for(int i = 0; i<m; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(cost < map[from][to])
				map[from][to] = cost;
		}
		// END OF INIT

		for(int k = 1; k<=n; k++){
			for(int i = 1; i<=n; i++){
				for(int j = 1; j<=n; j++){
					if(map[i][k] + map[k][j] < map[i][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(map[i][j] == INF)
					sb.append("0");
				else
					sb.append(map[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}




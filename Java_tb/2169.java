import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] map = null;
	static int[][] dp = null;
	static int[][] visited = null;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		for(int i = 0; i<=N+1; i++)	map[i][0] = map[i][M+1] = INF;
		for(int j = 0; j<=M+1; j++)	map[0][j] = map[N+1][j] = INF;
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		visited = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i = 1; i<=N; i++)
			for(int j = 1; j<=M; j++)
				dp[i][j] = INF * -1;
		dp[N][M] = map[N][M];
		visited[N][M] = 1;
		dfs(1, 1);
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		System.out.println(dp[1][1]);
	}
	
	public static void dfs(int i, int j){
		visited[i][j] = 1;
		int max = INF * -1;
		for(int s = 0; s<3; s++){
			int new_i = i+ii[s];	int new_j = j+jj[s];
			if(map[new_i][new_j] == INF)	continue;
			if(visited[new_i][new_j] == 0)
				dfs(new_i, new_j);
			if(max < dp[new_i][new_j])
				max = dp[new_i][new_j];
		}
		dp[i][j] = max + map[i][j];
		System.out.println(i+", "+j+" : "+dp[i][j]);
		visited[i][j] = 0;
	}
	
	static int[] ii = new int[]{0, 1, 0};
	static int[] jj = new int[]{-1, 0, 1};
}



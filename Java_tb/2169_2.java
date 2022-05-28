import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] map = null;
	static int[][][] dp = null;
	static final int NULL = 1000000000 * -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
	
		map = new int[N+2][M+2];
		for(int i = 0; i<=N+1; i++)	map[i][0] = map[i][M+1] = NULL;
		for(int j = 0; j<=M+1; j++)	map[0][j] = map[N+1][j] = NULL;
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[3][N+1][M+1];
		for(int i = 0; i<=N; i++)
			for(int j = 0; j<=M; j++)
				dp[0][i][j] = dp[1][i][j] = dp[2][i][j] = NULL;
				
		dp[0][N][M] = dp[1][N][M] = dp[2][N][M] = map[N][M];
		
		if(dp[2][1][1] == NULL)
			dfs(1, 1, 2);
		System.out.println(dp[2][1][1]);
	}
	
	public static void dfs(int i, int j, int from){

		int max = NULL;
		for(int s = 0; s<=2; s++){
			int new_i = i + ii[s];	int new_j = j + jj[s];
			if(map[new_i][new_j] == NULL || block[from] == s)
				continue;
			if(dp[s][new_i][new_j] == NULL)
				dfs(new_i, new_j, s);
			if(max < dp[s][new_i][new_j])
				max = dp[s][new_i][new_j];
		}
		dp[from][i][j] = max + map[i][j];
		
	}
	static int[] ii = new int[]{0, 1, 0};	// from 0, 1, 2;
	static int[] jj = new int[]{-1, 0, 1};
	static int[] block = new int[]{2, -1, 0};
}


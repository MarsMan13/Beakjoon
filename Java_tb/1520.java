import java.util.*;
import java.io.*;


class Main{
	
	static int M, N;
	static int[][] map = null;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());	N = Integer.parseInt(st.nextToken());
	
		map = new int[M+2][N+2];
		for(int i = 0; i<M+2; i++)	map[i][0] = map[i][N+1] = 99999;
		for(int j = 0; j<N+2; j++)	map[0][j] = map[M+1][j] = 99999;
		
		dp = new int[M+2][N+2];
		
		for(int i = 1; i<=M; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		//
		dp[1][1] = 1;
		System.out.println(dfs(M, N));
		
	}
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
	
	public static int dfs(int i, int j){

		if(map[i][j] == 99999 || 0 <= dp[i][j])
			return dp[i][j];
		
		int sum = 0;
		for(int k = 0; k<4; k++){
			int new_i = i + ii[k];	int new_j = j + jj[k];
			
			if(map[i][j] < map[new_i][new_j]){
				sum += dfs(new_i, new_j);
			}
		}
		return dp[i][j] = sum;
	}	
}







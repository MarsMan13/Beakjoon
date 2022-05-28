import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] map = null;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		//
		
		map = new int[N+2][M+2];
		dp = new int[N+2][M+2];
		for(int i = 1; i<=N; i++)
			for(int j = 1; j<=M; j++)	dp[i][j] = -1;
		
		for(int i = 0; i<=N+1; i++)	map[i][0] = map[i][M+1] = 0;
		for(int j = 0; j<=M+1; j++)	map[0][j] = map[N+1][j] = 0;
		
		for(int i = 1; i<=N; i++){
			String line = bf.readLine();
			for(int j = 1; j<=M; j++){
				char tempC = line.charAt(j-1);
				if(tempC == 'H')	tempC = '0';
				map[i][j] = tempC - '0';
			}
		}
		System.out.println(dfs(1, 1));
	}
	
	public static int dfs(int i, int j){
		
		if(i<=0 || N<i || j<=0 || M<j || map[i][j] == 0)
			return 0;
		if(dp[i][j] > -1)
			return dp[i][j];
		if(dp[i][j] == -2){
			System.out.println(-1);
			System.exit(0);
		}
		//
		dp[i][j] = -2;
		int ret = 0;
		for(int s = 0; s<4; s++){
			int new_i = i+ii[s] * map[i][j];
			int new_j = j+jj[s] * map[i][j];
			
			int temp = dfs(new_i, new_j);
			if(ret < temp)	ret = temp;
		}
		return dp[i][j] = ret + 1;
		
	}
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
}

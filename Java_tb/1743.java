import java.util.*;
import java.io.*;

class Main{
	
	static int N, M, K;
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];

		for(int k = 0; k<K; k++){
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			map[i][j] = 1;
		}
		// END OF INIT
		int maxCount = 0;
		visited = new int[N+2][M+2];
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				if(map[i][j] == 1 && visited[i][j] == 0){
					maxCount = Math.max(maxCount, dfs(i, j));
				}
			}
		}
		System.out.println(maxCount);
	}

	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};


	static int dfs(int i, int j){
		visited[i][j] = 1;
		int ret = 1;
		for(int k = 0; k<4; k++){
			int newI = i + ii[k];
			int newJ = j + jj[k];
			if(map[newI][newJ] == 1 && visited[newI][newJ] == 0){
				ret += dfs(newI, newJ);
			}
		}
		return ret;
	}
}
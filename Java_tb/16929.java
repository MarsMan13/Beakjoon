import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static char[][] map;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int[N][M];
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<M; j++){
				map[i][j] = line.charAt(j);
			}
		}
		// END OF INIT
		boolean result = false;
		OUTER:
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(visited[i][j] == 0){
					int result_ = dfs(i, j, i * M + j + 1, map[i][j], -1);
					if(result_ == 1){
						result = true;
						break OUTER;
					}
				}
			}
		}
		System.out.println(result ? "Yes" : "No");
	}

	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};

	public static int dfs(int i, int j, int root, char color, int fromIndex){
		visited[i][j] = root;
		for(int k = 0; k<4; k++){
			int nextI = i + ii[k];
			int nextJ = j + jj[k];
			if(
				!(0 <= nextI && nextI < N && 0 <= nextJ && nextJ < M) 
				|| (map[nextI][nextJ] != color)
				|| (nextI * N + nextJ == fromIndex)
			){
				continue;
			}
			//
			if(visited[nextI][nextJ] == root){
				return 1;
			}
			else if(visited[nextI][nextJ] == 0){
				int ret = dfs(nextI, nextJ, root, color, i * N + j);
				if(ret == 1){
					return 1;
				}
			}
		}
		return 0;
	}
}
import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static int[][] map = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int i = Integer.parseInt(st.nextToken());	int j = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int ii = 0; ii<N; ii++){
			st = new StringTokenizer(bf.readLine());
			for(int jj = 0; jj<M; jj++){
				map[ii][jj] = Integer.parseInt(st.nextToken());
			}
		}
		// END-OF-INIT
		dfs(i, j, d, 1);
	}

	public static void dfs(int i, int j, int d, int count){
		map[i][j] = 2;
		for(int s = 0; s<4; s++){
			int newD = (d + 3 - s)%4;
			int newI = i + ii[s];
			int newJ = j + jj[s];
			if(newI < 0 || Main.N <= newI || newJ < 0 || Main.M <= newJ || map[newI][newJ] != 0)	
				continue;
			dfs(newI, newJ, newD, count+1);
		}
		int backIndex = (d+2 < 4) ? d+2 : d-2;
		int backI = i + ii[backIndex];
		int backJ = j + jj[backIndex];
		if(0<=backI && backI <= Main.N && 0<=backJ && backJ <= Main.M){
			if(map[backI][backJ] != 1){
				dfs(backI, backJ, d, count);
			}
			else{
				System.out.println(count);
				System.exit(0);
			}
		}
	}
	
	static int[] ii = new int[]{-1, 0, 1, 0};
	static int[] jj = new int[]{0, 1, 0, -1};
}
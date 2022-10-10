import java.util.*;
import java.io.*;

class Main{
	
	static int H, W;
	static int[][] map = null;
	static boolean[][] visited = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		H = Integer.parseInt(st.nextToken());	W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W];
		st = new StringTokenizer(bf.readLine());
		for(int j = 0; j<W; j++){
			int h = Integer.parseInt(st.nextToken());
			for(int i = 0; i<h; i++){
				map[i][j] = 1;
				visited[i][j] = true;
			}
		}
		// END OF INIT
		for(int i = 0; i<H; i++){
			boolean leftWallFlag = false;
			for(int j = 0; j<W; j++){
				if(visited[i][j] == false && )
			}
		}
	}
	static int[] ii = {0, 0};
	static int[] jj = {-1, 1};

	static boolean goRight(int i, int j){
		if(W <= j)	return false;
		if(map[i][j] == 1)	return true;
		return visited[i][j] = (goRight(i, j+1) && (0 < i ? visited[i-1][j] : true));
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StingTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// END OF INIT
		for(int s = 2; i<=N; i++){
			for(int i = 1; i<=s; i++){
				
			}
			for(int j = 1; j<=s; j++){
				
			}
		}
	}
	
	static int[] ii = {0, 1, 1};
	static int[] jj = {1, 0, 1};	
	
	static int[][] steps = new int[][]{{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};	
	static int[][] check = new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};	
}
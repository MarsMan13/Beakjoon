import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[][] map = null;
	static int[][] mapType1 = null;
	static int[][] mapType2 = null;
	static int[][] mapType3 = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+2][N+2];
		mapType1 = new int[N+1][N+1];
		mapType2 = new int[N+1][N+1];
		mapType3 = new int[N+1][N+1];
		
		for(int i = 1; i<=N; i++){
			map[i][0] = map[i][N+1] = map[0][i] = map[N+1][i] = 1;
		}
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		mapType1[1][2] = 1;
		
		// END OF INIT
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=N; j++){
				if(map[i][j] == 1)
					continue;
				if(map[i-1][j] == 0 && map[i][j-1] == 0)
					mapType3[i][j] = mapType1[i-1][j-1] + mapType2[i-1][j-1] + mapType3[i-1][j-1];
				mapType1[i][j] = mapType1[i][j-1] + mapType3[i][j-1];
				mapType2[i][j] = mapType2[i-1][j] + mapType3[i-1][j];
			}
		}
		
		System.out.println(mapType1[N][N] + mapType2[N][N] + mapType3[N][N]);
	}
}



import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	// size of the map
		M = Integer.parseInt(st.nextToken());	// The number of calculating
	
		map = new int[N+1][N+1];
		int[][] storedMap = new int[N+1][N+1];
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			int store = 0;
			for(int j = 1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				store += map[i][j];
				storedMap[i][j] = store;
			}
		}
		
		// 
		int[][] question = new int[M][4];
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<4; j++)
				question[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// END OF INIT
	
		StringBuilder sb = new StringBuilder();
		for(int q = 0; q<M; q++){
			int result = 0;
			
			int from = question[q][1];
			int to = question[q][3];
			for(int i = question[q][0]; i<=question[q][2]; i++){
				result += storedMap[i][to] - storedMap[i][from-1];
			}
			sb.append(result);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}

import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static double answer = 0.;
	static int[] prob = new int[4];
	static int[][] map = new int[50][50];
	static final int START_I = 25;
	static final int START_J = 25;
	static int[] ii = new int[]{0, 0, -1, 1};
	static int[] jj = new int[]{1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<4; i++){
			prob[i] = Integer.parseInt(st.nextToken());
		}
		// END OF INIT
		dfs(START_I, START_J, 0, 1.);
		System.out.println(answer);
	}

	public static void dfs(int i, int j, int steps, double p){
		if(N < steps){
			answer += p;
			return;
		}
		for(int k = 0; k<4; k++){
			int newI = i + ii[k];
			int newJ = j + jj[k];
			if(map[newI][newJ] == 0){
				map[newI][newJ] = 1;
				dfs(newI, newJ, steps+1, p*(prob[k]/100.));
				map[newI][newJ] = 0;
			}
		}
	}
}

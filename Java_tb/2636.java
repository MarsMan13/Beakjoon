import java.util.*;
import java.io.*;


class Main{

	static int N, M;
	static int[][] input = null;
	static int[][] result = null;
	static int[][] visited = null;
	
	static int[] xx = new int[]{1, -1, 0, 0};
	static int[] yy = new int[]{0, 0, 1, -1};
	static int step = 0;

	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N+2][M+2];
		result = new int[N+2][M+2];

		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=M; j++){
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// END OF INIT
	
		def1(0);

		int counter = 0;
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				if(result[i][j] == step)
					counter++;
			}
		}
		System.out.println(step);
		System.out.println(counter);
	}

	static void def2(int i, int j){
		for(int k = 0; k<4; k++){
			if(visited[i+xx[k]][j+yy[k]] == 0 && input[i+xx[k]][j+yy[k]] == 0){
				visited[i+xx[k]][j+yy[k]] = 1;
				def2(i+xx[k],j+yy[k]);
			}
		}
	}

	static void def1(int target){

		int marker = target + 1;

		int flag = 0;

		// About Air
		visited = new int[N+2][M+2];
		for(int i = 1; i<=N; i++){
			visited[i][0] = visited[i][M+1] = 1;
		}
		for(int i = 1; i<=M; i++){
			visited[0][i] = visited[N+1][i] = 1;
		}
		visited[1][1] = 1;
		def2(1,1);

		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				
				int beMarked = 0;
				for(int k = 0; k<4; k++){
					if(input[i][j] == 1 && visited[i+xx[k]][j+yy[k]] == 1){
						beMarked = 1;
						flag = 1;
					}
				}
				if(beMarked == 1){
					input[i][j] = 0;
					result[i][j] = marker;
				}
			}
		}
		
		if(step < target)
			step = target;
		if(flag == 0)
			return;
		def1(target+1);
	}
}

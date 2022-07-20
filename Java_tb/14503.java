import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(bf.readLine());
		Robot robot = new Robot(
			Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
			);
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// END OF INIT


	}
}

class Robot{
	int i, j;
	int d;
	Robot(int i, int j, int d){
		this.i = i;
		this.j = j;
		this.d = d;
	}

	public void doStep(int[][] map){
		// STEP1
		map[i][j] = 2;
		// STEP2s
		// STEP2-1
		int leftDirection = (d - 1 == -1 ? 3 : d - 1);
		int leftI = i + ii[leftDirection];
		int leftJ = j + jj[leftDirection];
		if(map[leftI][leftJ] == 0){
			d = leftDirection;
			i = leftI;
			j = leftJ;
			doStep(map);
		}
		else if(map[leftI][leftJ] != )
	}

	static int[] ii = new int[]{-1, 0, 1, 0};
	static int[] jj = new int[]{0, 1, 0, -1};
}
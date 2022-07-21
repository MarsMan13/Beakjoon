import java.util.*;
import java.io.*;

class Main{
	static int N = 0;
	static int M = 0;	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
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
		robot.time = new int[N][M];
		robot.doStep(map);
		//
		int count = 0;
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(map[i][j] == 2)
					count++;
				System.out.printf("%2d ", robot.time[i][j]);
			}
			System.out.println();
		}
		System.out.println(count);
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
	int[][] time = null;
	int t = 1;
	public int doStep(int[][] map){
		time[this.i][this.j] = t++;
		// STEP1
		map[i][j] = 2;
		// STEP2s
		// STEP2 - 1,2
		for(int s = 0; s<4; s++){
			this.d = (this.d + 3) % 4;	
			int newI = i + ii[this.d];
			int newJ = j + jj[this.d];
			if(0 <= newI && newI < Main.N && 0 <= newJ && newJ < Main.M && map[newI][newJ] == 0){
				this.i = newI;	this.j = newJ;
				int ret = doStep(map);
				if(ret == 1)
					return 1;
			}
		}
		// STEP2 - 3,4
		int backI = i + ii[(d+2)%4];
		int backJ = j + jj[(d+2)%4];
		if(0 <= backI && backI < Main.N && 0 <= backJ && backJ < Main.M && map[backI][backJ] == 2){
			this.i = backI;
			this.j = backJ;
			return 0;
		}
		return 1;
	}

	static int[] ii = new int[]{-1, 0, 1, 0};
	static int[] jj = new int[]{0, 1, 0, -1};
}
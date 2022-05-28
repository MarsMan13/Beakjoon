import java.util.*;
import java.io.*;


class Main17070{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Pair.init(Integer.parseInt(st.nextToken()));
		for(int i = 1; i<=Pair.N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=Pair.N; j++){
				Pair.map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 

		int map[][] = new int[Pair.N+1][Pair.N+1];
		int count = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 1, 2));
		while(!(queue.isEmpty())){
			Pair temp = queue.poll();
			if(temp.type == 0)
				map[temp.i][temp.j]++;
			if(temp.i == Pair.N && temp.j == Pair.N){
				count++;
				continue;
			}
			int[][] next = temp.nextPos();
			for(int i = 0; i<3; i++){
				if(next[i][0] == -1)
					break;
				queue.offer(new Pair(next[i][2], next[i][0], next[i][1]));
			}
		}
	
		for(int i = 1; i<=Pair.N; i++){
			for(int j = 1; j<=Pair.N; j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(count);
	}
	
	static int[] steps = new int[]{2, 2, 3};
	static int[][] ii = new int[][]{{0, 1}, {1, 1}, {0, 1, 1}};
	static int[][] jj = new int[][]{{1, 1}, {0, 1}, {1, 0, 1}};
}

class Pair{
	
	static int N;
	static int[][] map = null;
	
	int i, j;
	int type;

	static void init(int N){
		Pair.N = N;
	
		map = new int[N+2][N+2];
		for(int i = 0; i<=N+1; i++){
			map[i][0] = map[i][N+1] = map[0][i] = map[N+1][i] = 1;
		}
	}
	
	Pair(int type, int i, int j){
		this.type = type;
		this.i = i; this.j = j;
	}

	public int[][] nextPos(){

		int index = 0;
		int[][] ret = new int[][]{
			{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}
		};
		
		for(int i = 0; i<3; i++){
			if(steps[type][i] == 1){
				int flag = 0;
				for(int c = 0; c<3; c++){
					if(check[i][c] == 1){
						int check_i = this.i + ii[c];
						int check_j = this.j + jj[c];
						if(map[check_i][check_j] == 1)
							flag = 1;
					}
				}
				if(flag == 1)
					continue;
				int new_i = this.i + ii[i];
				int new_j = this.j + jj[i];
				ret[index][0] = new_i;	ret[index][1] = new_j;
				ret[index++][2] = i;
			}
		}
		return ret;
	}
	static int[][] steps = new int[][]{{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};	
	// each type => able movement
	static int[][] check = new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};	
	// each movement => point to be checked
	static int[] ii = {0, 1, 1};
	static int[] jj = {1, 0, 1};	
	
}




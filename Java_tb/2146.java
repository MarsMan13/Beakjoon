import java.util.*;
import java.io.*;

class Main{

	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		Deque<Pair> queue = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N; j++){
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp == 1){
					queue.add(new Pair(i, j));
				}
			}
		}

		while(!queue.isEmpty()){
			Pair pair = queue.poll();
			for(int k = 0; k<4; k++){
				
			}
		}

		

	}
}

class Pair{

	int i, j;
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
}
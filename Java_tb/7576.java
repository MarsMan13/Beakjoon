import java.util.*;
import java.io.*;



class Main{
	
	static int M, N;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		for(int i = 0; i<N+2; i++){
			map[i][0] = map[i][M+1] = -1;
		}
		for(int i = 0; i<M+2; i++){
			map[0][i] = map[N+1][i] = -1;
		}
		Queue<Pair> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1){
					queue.offer(new Pair(i, j, 0));
				}
			}
		}
	
		int min = -1;
		while(!(queue.isEmpty())){
			Pair temp = queue.poll();
			if(min < temp.time)
				min = temp.time;
			for(int k = 0; k<4; k++){
				int next_i = temp.i + ii[k];
				int next_j = temp.j + jj[k];
				
				if(map[next_i][next_j] == 0){
					map[next_i][next_j] = 1;
					queue.offer(new Pair(next_i, next_j, temp.time+1));
				}
			}
		}
	
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				if(map[i][j] == 0){
					System.out.println(-1);
					return;
				}
			}	
		}
		System.out.println(min);
		
	}
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
}

class Pair{
	
	int i, j;
	int time = 0;
	Pair(int i, int j, int time){
		this.i = i;
		this.j = j;
		this.time = time;
	}
}

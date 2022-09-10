import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<M; j++){
				map[i][j] = line.charAt(j) == '1' ? 1 : 0;
			}
		}
		// END OF INIT
		int[][] distFrom = new int[N][M];
		int[][] distTo = new int[N][M];
		bfs(distFrom, 0, 0);
		bfs(distTo, N-1, M-1);
		int result = distFrom[N-1][M-1];
		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if(map[i][j] == 0)	continue;
				// i, j IS WALL.
				for(int k = 0; k<4; k++){
					int fromI = i + ii[k];
					int fromJ = j + jj[k];
					if(!(0<= fromI && fromI < N && 0<=fromJ && fromJ < M)
						|| map[fromI][fromJ] == 1)	
						continue;

					for(int kk = 0; kk<4; kk++){
						if(k == kk) continue;
						int toI = i + ii[kk];
						int toJ = j + jj[kk];
						if(!(0<=toI && toI<N && 0<=toJ && toJ < M)
							|| map[toI][toJ] == 1)	continue;
						// PROCESS
						int f = distFrom[fromI][fromJ];
						int t = distTo[toI][toJ];
						if(f == 0 || t == 0)	continue;
						if(result == 0 || f + t + 1 < result)	
							result = f + t + 1;
					}
				}
			}
		}
		System.out.println(result == 0 ? -1 : result);
	}
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};

	public static void bfs(int[][] info, int i, int j){
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(i, j));
		info[i][j] = 1;
		while(!queue.isEmpty()){
			Pair cur = queue.poll();
			for(int k = 0; k<4; k++){
				int newI = cur.i + ii[k];
				int newJ = cur.j + jj[k];
				if(!(0 <= newI && newI < N && 0<= newJ && newJ < M)
				|| (map[newI][newJ] == 1)
				|| (info[newI][newJ] != 0)){
					continue;
				}
				//
				info[newI][newJ] = info[cur.i][cur.j] + 1;
				queue.offer(new Pair(newI, newJ));
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
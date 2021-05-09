import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[][] map = null;
	static int[][] fromS = null;
	static int[][] fromD = null;
	static int INF = 10000000;
	static int answer = INF;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		for(int i = 0; i<=N+1; i++)
			map[i][0] = map[i][M+1] = 1;
		for(int j = 0; j<=M+1; j++)
			map[0][j] = map[N+1][j] = 1;
		for(int i = 1; i<=N; i++){
			String line = bf.readLine();
			for(int j = 1; j<=M; j++){
				char point = line.charAt(j-1);
				if(point == '0')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		// END OF INIT
		
		int[][] visited = new int[N+2][M+2];
		int[][] fromS = new int[N+2][M+2];
		int[][] fromD = new int[N+2][M+2];
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++)
				fromS[i][j] = fromD[i][j] = INF;
		}
		
		// step1
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(1, 1, 1));
		visited[1][1] = 1;
		fromS[1][1] = 1;
		while(!(queue.isEmpty())){
			Point temp = queue.poll();
			if(temp.i == N && temp.j == M)
				answer = temp.time;
			for(int k = 0; k<4; k++){
				int next_i = temp.i + ii[k]; int next_j = temp.j + jj[k];
				if(map[next_i][next_j] == 0 && visited[next_i][next_j] == 0){
					visited[next_i][next_j] = 1;
					queue.offer(
						new Point(next_i, next_j, temp.time + 1)
					);
					fromS[next_i][next_j] = temp.time+1;
				}
			}
		}
		queue = new LinkedList<>();
		visited = new int[N+2][M+2];
		queue.offer(new Point(N, M, 1));
		visited[N][M] = 1;
		fromD[N][M] = 1;
		while(!(queue.isEmpty())){
			Point temp = queue.poll();
			for(int k = 0; k<4; k++){
				int next_i = temp.i + ii[k]; int next_j = temp.j + jj[k];
				if(map[next_i][next_j] == 0 && visited[next_i][next_j] == 0){
					visited[next_i][next_j] = 1;
					queue.offer(
						new Point(next_i, next_j, temp.time + 1)
					);
					fromD[next_i][next_j] = temp.time+1;
				}
			}
		}
		
		// step2
		for(int i = 1; i<=N; i++){
			for(int j = 1; j<=M; j++){
				if(map[i][j] == 1){
					int minS = INF;
					int minD = INF;
					for(int k = 0; k<4; k++){
						int next_i = i + ii[k];
						int next_j = j + jj[k];
						if(map[next_i][next_j] == 0 && fromS[next_i][next_j] != INF){
							if(fromS[next_i][next_j] + 1 < minS)
								minS = fromS[next_i][next_j] + 1;
						}
						if(map[next_i][next_j] == 0 && fromD[next_i][next_j] != INF){
							if(fromD[next_i][next_j] + 1 < minD)
								minD = fromD[next_i][next_j] + 1;
						}
					}
					
					if(minS + minD -1 < INF && minS + minD - 1 < answer)
						answer = minS + minD - 1;
				}
			}
		}
		if(answer == INF)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static int[] ii = {1, -1, 0 ,0};
	static int[] jj = {0, 0, 1, -1};
}


class Point{
	int i, j;
	int time;
	Point(int i, int j, int time){
		this.i = i;
		this.j = j;
		this.time = time;
	}
}


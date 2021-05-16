import java.util.*;
import java.io.*;



class Main{
	
	static int N, M;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];	
		// 0 : all air, 1 : cheeze, -1 : out air, 9 : wall
		for(int i = 0; i<=N+1; i++)
			map[i][0] = map[i][M+1] = 9;
		for(int j = 0; j<=M+1; j++)
			map[0][j] = map[N+1][j] = 9;
		int cheezeNum = 0;
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=M; j++){
				cheezeNum += (map[i][j] = Integer.parseInt(st.nextToken()));
			}
		}
		map[1][1] = -1;	// out air
		// END OF INIT
		int t = 0;
		outer: while(0 < cheezeNum){
			t++;
			Queue<Pair> queue = new LinkedList<>();
			queue.offer(new Pair(1, 1));
			while(!(queue.isEmpty())){
				Pair temp = queue.poll();
				for(int k = 0; k<4; k++){
					int new_i = temp.i + ii[k];
					int new_j = temp.j + jj[k];
					if(map[new_i][new_j] == 0){
						map[new_i][new_j] = -1;
						queue.offer(new Pair(new_i, new_j));
					}
				}
			}
			// END OF finding out air
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=M; j++){
					if(map[i][j] == 1){
						int outAirNum = 0;
						for(int k = 0; k<4; k++){
							int new_i = i+ii[k];	int new_j = j+jj[k];
							if(map[new_i][new_j] == -1){
								outAirNum++;
							}
						}
						if(2 <= outAirNum){
							map[i][j] = 0;
							if(--cheezeNum == 0){
								break outer;
							}
						}
					}
				}
			}
			// END OF melting cheezes
			for(int i = 1; i<=N; i++){
				for(int j = 1; j<=M; j++){
					if(map[i][j] == -1)
						map[i][j] = 0;
				}
			}
		}
		
		System.out.println(t);
		
	}
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
}

class Pair{
	int i, j;
	Pair(int i, int j){
		this.i = i; this.j = j;
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int[] ii = new int[]{1, -1, 0, 0};
	static int[] jj = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R+2][C+2];
		Queue<Triple> queue = new LinkedList<>();
		int[][] visited = new int[R+2][C+2];
		Triple Zihoon = null;	
		for(int i = 1; i<=R; i++){
			String line = bf.readLine();
			for(int j = 1; j<=C; j++){
				map[i][j] = line.charAt(j-1);
				if(map[i][j] == 'J')
					Zihoon = new Triple(i, j, 0);
				else if(map[i][j] == 'F'){
					queue.offer(new Triple(i, j, 0));
					visited[i][j] = 1;
				}
			}
		}
		int[][] fireMap = new int[R+2][C+2];
		for(int i = 0; i<R+2; i++)
			for(int j = 0; j<C+2; j++)
				fireMap[i][j] = 1000000;
		while(!queue.isEmpty()){
			Triple cur = queue.poll();
			fireMap[cur.i][cur.j] = cur.k;
			for(int k = 0; k<4; k++){
				int new_i = cur.i + ii[k];
				int new_j = cur.j + jj[k];
				if(visited[new_i][new_j] == 0 && (map[new_i][new_j] == '.' || map[new_i][new_j] == 'J')){
					visited[new_i][new_j] = 1;
					queue.offer(new Triple(new_i, new_j, cur.k+1));
				}
			}
		}
		//
		visited = new int[R+2][C+2];
		queue = new LinkedList<>();
		queue.offer(Zihoon);
		visited[Zihoon.i][Zihoon.j] = 1;
		while(!queue.isEmpty()){
			Triple cur = queue.poll();
			if(map[cur.i][cur.j] == 0){
				System.out.println(cur.k);
				return;
			}
			for(int k = 0; k<4; k++){
				int new_i = cur.i + ii[k];
				int new_j = cur.j + jj[k];
				if(visited[new_i][new_j] == 0 && ((map[new_i][new_j] == '.' && cur.k+1 < fireMap[new_i][new_j]) || map[new_i][new_j] == 0)){
					visited[new_i][new_j] = 1;
					queue.offer(new Triple(new_i, new_j, cur.k+1));
				}
			}
		}
		System.out.println("IMPOSSIBLE");

	}
}

class Triple{
	int i, j, k;
	Triple(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
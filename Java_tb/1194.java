import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Queue<Status> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[64][N][M];
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<M; j++){
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0'){
					queue.offer(new Status(i,j,0,0));
					visited[0][i][j] = true;
				}
			}
		}
		int sucFlag = -1;
		// END OF INIT
		while(!queue.isEmpty()){
			Status cur = queue.poll();
			if(map[cur.row][cur.col] == '1'){
				sucFlag = cur.steps;
				break;
			}
			for(int k = 0; k<4; k++){
				int newRow = cur.row + ii[k];
				int newCol = cur.col + jj[k];
				if(newRow < 0 || N <= newRow || newCol < 0 || M <= newCol)	continue;
				switch(map[newRow][newCol]){
					case '.': case '0': case '1':
						if(!visited[cur.keys][newRow][newCol]){
							Status newStatus = new Status(newRow, newCol, cur.steps+1, cur.keys);
							visited[newStatus.keys][newStatus.row][newStatus.col] = true;
							queue.offer(newStatus);
						}
						break;
					case '#':
						break;
					case 'a':case 'b': case 'c':case 'd':case 'e':case 'f':
						if(!visited[Status.addKey(cur.keys, map[newRow][newCol])][newRow][newCol]){
							Status newStatus = new Status(newRow, newCol, cur.steps+1, Status.addKey(cur.keys, map[newRow][newCol]));
							visited[newStatus.keys][newStatus.row][newStatus.col] = true;
							queue.offer(newStatus);
						}
						break;
					case 'A':case 'B': case 'C': case 'D': case 'E': case 'F':
						if(Status.checkKey(cur.keys, map[newRow][newCol])){
							if(!visited[cur.keys][newRow][newCol]){
								Status newStatus = new Status(newRow, newCol, cur.steps+1, cur.keys);
								visited[newStatus.keys][newStatus.row][newStatus.col] = true;
								queue.offer(newStatus);
							}
						}
						break;
				}
			}
		}
		System.out.println(sucFlag);
	}

	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
}

class Status{
	int row, col;
	int steps;
	int keys;
	Status(int row, int col, int steps, int keys){
		this.row = row;
		this.col = col;
		this.steps = steps;
		this.keys = keys;
	}

	static int addKey(int keys, char key){
		return keys | (1 << (key - 'a'));
	}

	static boolean checkKey(int keys, char key){
		return (keys & 1 << (key - 'a')) >> (key - 'a') == 1; 
	}
}
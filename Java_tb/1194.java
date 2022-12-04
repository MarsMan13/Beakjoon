import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+2][M+2];
		for(int i = 0; i<=N+1; i++)	map[i][0] = map[i][M+1] = '#';
		for(int j = 0; j<=M+1; j++)	map[0][j] = map[N+1][j] = '#';
		Queue<Status> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++){
			String line = bf.readLine();
			for(int j = 1; j<=M; j++){
				map[i][j] = line.charAt(j-1);
				if(map[i][j] == '0')
					queue.offer(new Status(i,j,0,0));
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
				switch(map[newRow][newCol]){
					case '.': case '0': case '1':
						queue.offer(new Status(newRow, newCol, cur.steps+1, cur.keys));
						break;
					case '#':
						break;
					case 'a':case 'b': case 'c':case 'd':case 'e':case 'f':
						queue.offer(
							new Status(newRow, newCol, cur.steps+1, 
							Status.addKey(cur.keys, map[newRow][newCol])));
						break;
					case 'A':case 'B': case 'C': case 'D': case 'E': case 'F':
						if(Status.checkKey(cur.keys, map[newRow][newCol])){
							queue.offer(
								new Status(newRow, newCol, cur.steps+1, cur.keys));
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
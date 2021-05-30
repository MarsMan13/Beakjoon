import java.util.*;
import java.io.*;


class Main{
	
	static int h, w;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t<T; t++){
		
			st = new StringTokenizer(bf.readLine());
			h = Integer.parseInt(st.nextToken());	w = Integer.parseInt(st.nextToken());
			int[][] visited = new int[h+2][w+2];
			
			char[][] map = new char[h+2][w+2];
			for(int i = 0; i<w+2; i++)
				map[i][0] = map[i][w+1] = '*';
			for(int j = 0; j<h+2; j++)
				map[0][j] = map[h+1][j] = '*';
			for(int i = 0; i<h; i++){
				String line = bf.readLine();
				for(int j = 0; j<w; j++){
					map[i][j] = line.charAt(j);
				}
			}
			//
			int[] keyQ = new int[26];
			String keys = bf.readLine();
			for(int i = 0; i<keys.length(); i++)
				keyQ[keys.charAt(i) - 'a'] = 1;
			//
			Queue<Point> queue = new LinkedList<>();
			for(int i = 1; i<=h; i++){
				if('A' <= map[i][1] && map[i][1] <= 'Z'){
					if(keyQ[map[i][1]-'A'+'a'] == 1){
						map[i][1] = '.';
					}
				}
				if('A' <= map[i][w] && map[i][w] <= 'Z'){
					if(keyQ[map[i][w]-'A'+'a'] == 1){
						map[i][w] = '.';
					}
				}
				if(map[i][1] == '.'){
					queue.add(new Point(i, 1));
					visited[i][1] = 1;
				}
				if(map[i][w] == '.'){
					queue.add(new Point(i, w));
					visited[i][w] = 1;
				}
			}
			for(int j = 1; j<=w; j++){
				if('A' <= map[1][j] && map[1][j] <= 'Z'){
					if(keyQ[map[1][j]-'A'+'a'] == 1){
						map[1][j] = '.';
					}
				}
				if('A' <= map[h][j] && map[h][j] <= 'Z'){
					if(keyQ[map[h][j]-'A'] == 1){
						map[h][j] = '.';
					}
				}
				if(map[1][j] == '.'){
					queue.add(new Point(1, j));
					visited[1][j] = 1;
				}
				if(map[w][j] == '.'){
					queue.add(new Point(w, j));
					visited[w][j] = 1;
				}
			}
		
			//
			ArrayList[] doorQ = new ArrayList[26];
			for(int i = 0; i<26; i++)
				doorQ[i] = new ArrayList<Point>();
			int ret = 0;
			while(!(queue.isEmpty())){
				Point cur = queue.poll();
				for(int k = 0; k<4; k++){
					int new_i = cur.i + ii[k];
					int new_j = cur.j + jj[k];
					//
					if(map[new_i][new_j] == '.' && visited[new_i][new_j] == 0){
						visited[new_i][new_j] = 1;
						queue.offer(new Point(new_i, new_j));
					}
					else if('A' <= map[new_i][new_j] && map[new_i][new_j] <= 'Z'){
						int doorIndex = map[new_i][new_j] - 'A';
						if(keyQ[doorIndex] != 0){
							map[new_i][new_j] = '.';
							visited[new_i][new_j] = 1;
							queue.offer(new Point(new_i, new_j));
						}
						else{
							doorQ[doorIndex].add(new Point(new_i, new_j));
						}
					}
					else if(map[new_i][new_j] == '$'){
						ret++;
						map[new_i][new_j] = '.';
						visited[new_i][new_j] = 1;
						queue.offer(new Point(new_i, new_j));
					}
				}
			}
			
			
			
		}
	}
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
}

class Point{
	int i, j;
	Point(int i, int j){
		this.i = i;	this.j = j;
	}
}





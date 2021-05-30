import java.util.*;
import java.io.*;


class Main{
	
	static int h, w;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
	
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
		
			st = new StringTokenizer(bf.readLine());
			h = Integer.parseInt(st.nextToken());	w = Integer.parseInt(st.nextToken());
			int[][] visited = new int[h+2][w+2];
			
			char[][] map = new char[h+2][w+2];
			for(int i = 0; i<h+2; i++)
				map[i][0] = map[i][w+1] = '.';
			for(int j = 0; j<w+2; j++)
				map[0][j] = map[h+1][j] = '.';
			
			for(int i = 1; i<=h; i++){
				String line = bf.readLine();
				for(int j = 1; j<=w; j++){
					map[i][j] = line.charAt(j-1);
				}
			}
			//
			int[] keyQ = new int[26];
			String keys = bf.readLine();
			for(int i = 0; i<keys.length(); i++){
				if(keys.charAt(i) == '0')
					break;
				keyQ[keys.charAt(i) - 'a'] = 1;
			}
			//
			int ret = 0;
			Queue<Point> queue = new LinkedList<>();
			ArrayList[] doorQ = new ArrayList[26];
			for(int i = 0; i<26; i++)
				doorQ[i] = new ArrayList<Point>();
			
			queue.offer(new Point(0, 0));	
			//
			while(!(queue.isEmpty())){
				Point cur = queue.poll();
				for(int k = 0; k<4; k++){
					int new_i = cur.i + ii[k];
					int new_j = cur.j + jj[k];
					//
					if(new_i < 0 || h+1 < new_i || new_j < 0 || w+1 < new_j)
						continue;
					
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
					else if('a' <= map[new_i][new_j] && map[new_i][new_j] <= 'z'){
						int keyIndex = map[new_i][new_j] - 'a';
						keyQ[keyIndex]++;
						for(Point p : (ArrayList<Point>)doorQ[keyIndex]){
							int door_i = p.i;	int door_j = p.j;
							map[door_i][door_j] = '.';
							visited[door_i][door_j] = 1;
							queue.offer(new Point(door_i, door_j));
						}
						map[new_i][new_j] = '.';
						visited[new_i][new_j] = 1;
						queue.offer(new Point(new_i, new_j));
					}
					else if(map[new_i][new_j] == '$'){
						ret++;
						map[new_i][new_j] = '.';
						visited[new_i][new_j] = 1;
						queue.offer(new Point(new_i, new_j));
					}
				}
			}
			
			sb.append(ret);	sb.append("\n");	
		}
		System.out.println(sb.toString());
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





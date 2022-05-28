import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();	
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Node[][] map = new Node[M+2][N+2];
			for(int k = 0; k<K; k++){
				st = new StringTokenizer(bf.readLine());
				Node newNode = new Node(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
				map[newNode.i][newNode.j] = newNode;
			}
			// END OF INIT
			
			int count = 0;
			for(int i = 1; i<=M; i++){
				for(int j = 1; j<=N; j++){
					if(map[i][j] != null && map[i][j].visited == 0){
						map[i][j].visited = 1;
						dfs(map, i, j);
						count++;
					}
				}
			}
			sb.append(count);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static int[] ii = {1, -1, 0, 0};
	static int[] jj = {0, 0, 1, -1};
	
	public static void dfs(Node[][] map, int i, int j){
		for(int k = 0; k<4; k++){
			int new_i = i+ii[k];
			int new_j = j+jj[k];
			if(map[new_i][new_j] != null && map[new_i][new_j].visited == 0){
				map[new_i][new_j].visited = 1;
				dfs(map, new_i, new_j);
			}
		}
	}
}

class Node{
	
	int i, j;
	int visited = 0;
	Node(int i, int j){
		this.i = i; this.j = j;
	}
}
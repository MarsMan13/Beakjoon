import java.util.*;
import java.io.*;

class Main{

	static int N;
	static int E;
	static int[][] map;
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i = 0; i<=N; i++)
			for(int j = 0; j<=N; j++)
				map[i][j] = INF;
		for(int i = 0; i<=N; i++)
			map[i][i] = 0;
		for(int i = 0; i<E; i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = c;
		}
		st = new StringTokenizer(bf.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		int path1 = 0, path2 = 0;
		{
			int subPath1 = getDistance(1, p1);
			int subPath2 = getDistance(p1, p2);
			int subPath3 = getDistance(p2, N);
			if(subPath1 == INF || subPath2 == INF || subPath3 == INF)
				path1 = INF;
			else	
				path1 = subPath1 + subPath2 + subPath3;
		}
		{
			int subPath1 = getDistance(1, p2);
			int subPath2 = getDistance(p2, p1);
			int subPath3 = getDistance(p1, N);
			if(subPath1 == INF || subPath2 == INF || subPath3 == INF)
				path2 = INF;
			else	
				path2 = subPath1 + subPath2 + subPath3;
		}
		int result = Math.min(path1, path2);
		System.out.println(result == INF ? -1 : result);
	}

	private static int getDistance(int start, int end){
		int[] distance = new int[N+1];
		int[] visited = new int[N+1];
		visited[start] = 1;
		for(int i = 1; i<=N; i++){
			distance[i] = map[start][i];
		}

		for(int s = 0; s<N-2; s++){
			int cur = getNextIndex(distance, visited);
			if(cur == 0)	break;
			visited[cur] = 1;
			for(int i = 1; i<=N; i++){
				if(visited[i] == 0 && distance[cur] + map[cur][i] < distance[i]){
					distance[i] = distance[cur] + map[cur][i];
				}
			}
		}
		return distance[end];
	}

	private static int getNextIndex(int[] distance, int[] visited){
		int minIndex = 0;
		int minValue = INF;
		for(int i = 1; i<=N; i++){
			if(visited[i] == 0 && distance[i] < minValue){
				minIndex = i;
				minValue = distance[i];
			}
		}
		return minIndex;
	}
}
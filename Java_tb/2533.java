import java.util.*;
import java.io.*;

class Main{

	static int N;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[][] dp = new int[1000001][2];	// 
	static int[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new int[N+1];
		Arrays.fill(visited, 0);
		for(int i = 0; i<=N; i++)
			graph.add(new ArrayList<>());
		for(int i = 0; i<N-1; i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		// END OF INIT
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	public static void dfs(int index){
		visited[index] = 1;
		dp[index][0] = 0;
		dp[index][1] = 1;

		for(int i = 0; i<graph.get(index).size(); i++){
			int next = graph.get(index).get(i);
			if(visited[next] == 1)
				continue;
			dfs(next);
			dp[index][0] += dp[next][1];
			dp[index][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
}
import java.util.*;
import java.io.*;



class Main{

	static int N = 0;
	static int M = 0;
	static int[] visited = null;
	static LinkedList<Integer>[] point = null;
	static Deque<Integer> result = new ArrayDeque<>();
	static int[] degree = null;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		point = new LinkedList[N+1];

		visited = new int[N+1];
		degree = new int[N+1];
		int from = 0;
		int to = 0;
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if(point[from] == null)
				point[from] = new LinkedList<Integer>();
			degree[to]+=1;
			point[from].add(to);
		}

		// END OF INIT

		for(int i = 1; i<=N; i++){
			if(visited[i] == 0){
				visited[i] = 1;
				dfs(i);
			}
		}

		// END OF PROCESS

		for(int i = result.size()-1; 0<=i; i--){
			System.out.print(result.pollFirst() + " ");
		}
		System.out.println();

	}

	static void dfs(int root){

		if(point[root] != null){
			for(int j : point[root]){
				if(visited[j] == 0){
					visited[j] = 1;
					dfs(j);
				}
			}
		}
		result.offerFirst(root);
	}
}

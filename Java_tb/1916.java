import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static final int INF = 1000000000;
	static Node[] nodes = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		nodes = new Node[N+1];	
		for(int i = 1; i<=N; i++)
			nodes[i] = new Node(i);
		for(int i = 0; i<M; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
		
			nodes[from].edge.add(new Edge(to, cost));
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		// END OF INIT
		
		int[] visited = new int[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		nodes[start].cost = 0;
		pq.offer(nodes[start]);
		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			visited[temp.index] = 1;
			for(Edge e : temp.edge){
				if(visited[e.to] == 0 && temp.cost + e.cost < nodes[e.to].cost){
					pq.remove(nodes[e.to]);
					nodes[e.to].cost = temp.cost + e.cost;
					pq.offer(nodes[e.to]);
				}
			}
		}
		System.out.println(nodes[end].cost);
	}
}

class Node implements Comparable<Node>{
	int index;
	int cost = Main.INF;
	List<Edge> edge = new LinkedList<Edge>();
	
	Node(int index){
		this.index = index;
	}
	
	@Override
	public int compareTo(Node o){
		return this.cost - o.cost;
	}
}

class Edge{
	
	int to, cost;
	
	Edge(int to, int cost){
		this.to = to; this.cost = cost;
	}
}

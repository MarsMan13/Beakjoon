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
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			//
			Node[] nodes = new Node[N+1];
			for(int i = 1; i<=N; i++)	nodes[i] = new Node(i);
			
			for(int k = 0; k<K; k++){
				st = new StringTokenizer(bf.readLine());
				int u = Integer.parseInt(st.nextToken());	int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				nodes[u].addEdge(new Edge(u, v, c));
			}
			
			nodes[1].cost = 0;
			pq.offer(nodes[1]);
			PriorityQueue<Node> pq = new PriorityQueue<>();
			while(!(pq.isEmpty())){
				Node tempNode = pq.poll();
				
			}
		}
	}
}

class Node implements Comparable<Node>{
	
	int index, cost = INF;
	List<Edge> edges = new ArrayList<>(); 
	
	Node(int index){
		this.index = index;
	}
	
	public void addEdge(Edge e){
		this.edges.add(e);
	}
	
	@Override
	public int compareTo(Node o){
		return this.cost - o.cost;
	}
	
	static int INF = 100000000;
}

class Edge{

	int from, to, cost;
	
	Edge(int from, int to, int cost){
		this.from = from;	this.to = to;	this.cost = cost;
	}
}



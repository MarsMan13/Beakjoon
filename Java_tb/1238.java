import java.util.*;
import java.io.*;



class Main{

	final static int INF = 1000000000;
	static int N, M, X;
	static Node[] nodes1 = null;
	static Node[] nodes2 = null;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		nodes1 = new Node[N+1];
		nodes2 = new Node[N+1];
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int from =  Integer.parseInt(st.nextToken());
			int to =  Integer.parseInt(st.nextToken());
			int cost =  Integer.parseInt(st.nextToken());

			if(nodes1[from] == null)
				nodes1[from] = new Node(from);
			if(nodes2[to] == null)
				nodes2[to] = new Node(to);
			nodes1[from].road.add(new Edge(to, cost));
			nodes2[to].road.add(new Edge(from, cost));
		}
		
		// END OF INIT
		PriorityQueue<Node> pq = new PriorityQueue<>();
		nodes1[X].dist = 0;	nodes2[X].dist = 0;
		pq.offer(nodes1[X]);
		int[] visited = new int[N+1];
		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			visited[temp.index] = 1;
			for(Edge e : temp.road){
				Node toNode = nodes1[e.to];
				if(visited[e.to] == 0 && temp.dist + e.cost < toNode.dist){
					pq.remove(toNode);
					toNode.dist = temp.dist + e.cost;
					pq.offer(toNode);
				}
			}
		}
		
		pq = new PriorityQueue<>();
		pq.offer(nodes2[X]);
		visited = new int[N+1];
		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			visited[temp.index] = 1;
			for(Edge e : temp.road){
				Node toNode = nodes2[e.to];
				if(visited[e.to] == 0 && temp.dist + e.cost < toNode.dist){
					pq.remove(toNode);
					toNode.dist = temp.dist + e.cost;
					pq.offer(toNode);
				}
			}
		}
		
		// END OF INIT
		int max = -1;
		for(int i = 1; i<=N; i++){
			if(max == -1 || max < nodes1[i].dist + nodes2[i].dist)
				max = nodes1[i].dist + nodes2[i].dist;
		}
		System.out.println(max);
	}
}


class Node implements Comparable<Node>{

	int index;
	int dist = Main.INF;
	
	List<Edge> road = new ArrayList<>();
	
	Node(int index){
		this.index = index;
	}
	
	@Override
	public int compareTo(Node o){
		return this.dist - o.dist;
	}
}

class Edge{
	
	int to, cost;
	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
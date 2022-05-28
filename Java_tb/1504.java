import java.util.*;
import java.io.*;



class Main{
	
	static int N, E;	// N : END POINT
	static final int INF = 1000000;
	static Node[] nodes = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		nodes = new Node[N+1];
		for(int i = 1; i<=N; i++)
			nodes[i] = new Node(i);
		for(int i = 0; i<E; i++){
			st = new StringTokenizer(bf.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[p1].edges.add(new Edge(p2, cost));
			nodes[p2].edges.add(new Edge(p1, cost));
		}
		st = new StringTokenizer(bf.readLine());
		int[] startPoint = new int[]{
			1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), N
		};
		int result1 = 0;
		for(int i = 0; i<3; i++){
			result1 += dijkstra(startPoint[i], startPoint[i+1]);
		}
		{
			int temp = startPoint[1];
			startPoint[1] = startPoint[2];
			startPoint[2] = temp;
		}
		int result2 = 0;
		for(int i = 0; i<3; i++){
			result2 += dijkstra(startPoint[i], startPoint[i+1]);
		}
		int result = result1 < result2 ? result1 : result2;
		if(INF <= result)
			System.out.println(-1);
		else
			System.out.println(result);
	}
	
	public static int dijkstra(int start, int end){
		for(int i = 1; i<=N; i++)
			nodes[i].dist = Main.INF;
		int[] visited = new int[N+1];
		nodes[start].dist = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(nodes[start]);
		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			visited[temp.index] = 1;
			for(Edge e : temp.edges){
				if(visited[e.to] == 0 && temp.dist + e.cost < nodes[e.to].dist){
					pq.remove(nodes[e.to]);
					nodes[e.to].dist = temp.dist + e.cost;
					pq.offer(nodes[e.to]);
				}
			}
		}
		return nodes[end].dist;
	}
}

class Node implements Comparable<Node>{
	int index;
	int dist = Main.INF;
	List<Edge> edges = new LinkedList<>();
	
	Node(int index){
		this.index = index;
	}
	
	@Override
	public int compareTo(Node o){
		return this.dist - o.dist;
	}
}

class Edge{
	int to;
	int cost;
	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}





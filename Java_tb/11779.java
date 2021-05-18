import java.util.*;
import java.io.*;


class Main{
	
	static int n, m;
	static int start, end;
	static Node[] nodes = null;
	static final int INF = 1000000000;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());	m = Integer.parseInt(bf.readLine());
		StringTokenizer st = null;
		nodes = new Node[n+1];
		for(int i = 1; i<=n; i++)
			nodes[i] = new Node(i);
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[from].edges.add(new Edge(to, cost));
		}
		st = new StringTokenizer(bf.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		//
		int[] visited = new int[n+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(nodes[start]);
		nodes[start].dist = 0;
		while(!(pq.isEmpty())){
			Node tempNode = pq.poll();
			visited[tempNode.index] = 1;
			for(Edge e : tempNode.edges){
				if(visited[e.to] == 0 && tempNode.dist + e.cost < nodes[e.to].dist){
					pq.remove(nodes[e.to]);
					nodes[e.to].dist = tempNode.dist + e.cost;
					nodes[e.to].from = tempNode.index;
					pq.offer(nodes[e.to]);
				}
			}
		}
		// END OF PROCESSING
		
		sb.append(nodes[end].dist);	sb.append("\n");
		def(1, end);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();	bw.close();
	}
	
	public static void def(int count, int index){
		if(nodes[index].from == -1){
			sb.append(count);	sb.append("\n");
			sb.append(index);	sb.append(" ");
			return;
		}
		def(count+1, nodes[index].from);
		sb.append(index);	sb.append(" ");
		return;
	}
}

class Node implements Comparable<Node>{

	int index;
	int dist = Main.INF;
	int from = -1;
	List<Edge> edges = new ArrayList<>();
	
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
		this.to = to; this.cost = cost;
	}
}

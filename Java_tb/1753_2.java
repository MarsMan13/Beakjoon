import java.util.*;
import java.io.*;



class Main{
	
	static int V, E, K;
	static List<Edge>[] edges = null;
	static Vertex[] vs = null;	
	static int INF = 20000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(bf.readLine());
		
		edges = new LinkedList[V+1];
		vs = new Vertex[V+1];
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		for(int i = 1; i<=V; i++){
			edges[i] = new LinkedList<Edge>();
			vs[i] = new Vertex(i, INF);
			if(i == K){
				vs[i].cost = 0;
			}
			pq.offer(vs[i]);
		}
		
		for(int i = 1; i<=E; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(to, cost));
		}
		
		while(!(pq.isEmpty())){
			Vertex tempVertex = pq.poll();
			int curIndex = tempVertex.index;
			for(Edge e : edges[curIndex]){
				if(tempVertex.cost + e.cost < vs[e.to].cost){
					pq.remove(vs[e.to]);
					vs[e.to].cost = tempVertex.cost + e.cost;
					pq.offer(vs[e.to]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; i++){
			if(vs[i].cost == INF)
				sb.append("INF");
			else
				sb.append(vs[i].cost);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		
		
	}
}

class Edge implements Comparable<Edge>{
	
	int to, cost;
	Edge(int to, int cost){
		this.to = to; this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o){
		return this.cost - o.cost;
	}
}

class Vertex implements Comparable<Vertex>{
	int index;
	int cost;
	Vertex(int index, int cost){
		this.index = index;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Vertex o){
		return this.cost - o.cost;
	}
}
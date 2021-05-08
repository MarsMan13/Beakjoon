import java.util.*;
import java.io.*;



class Main{
	
	static int V, E;
	static int K;
	static int INF = Integer.MAX_VALUE-20;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(bf.readLine());
		
		
		Vertex[] vs = new Vertex[V+1];		// vertexes
		PriorityQueue<Vertex> pq = new PriorityQueue<>();	// costs
		for(int i = 1; i<=V; i++){
			vs[i] = new Vertex(i, INF);
			if(i == K)
				vs[i].cost = 0;
			pq.offer(vs[i]);
		}
		
		for(int i = 1; i<=E; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
		
			vs[from].addEdge(new Edge(from, to, cost));
		}
		
		// END OF INIT
		
		while(!(pq.isEmpty())){
			Vertex pointer = pq.poll();
			pointer.visited = 1;
			int curCost = pointer.cost;
			for(Edge e : pointer.edges){
				if(vs[e.to].visited == 0 && curCost + e.cost < vs[e.to].cost){
					pq.remove(vs[e.to]);
					vs[e.to].cost = curCost + e.cost;
					pq.offer(vs[e.to]);
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=V; i++){
			if(vs[i].cost == INF){
				sb.append("INF");
			}
			else{
				sb.append(String.valueOf(vs[i].cost));
			}
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}
}


class Edge{
	
	int from, to;
	int cost;
	
	Edge(int from, int to, int cost){
		this.from = from; this.to = to;
		this.cost = cost;
	}
}

class Vertex implements Comparable<Vertex>{
	
	int index;
	int cost;
	int visited = 0;
	List<Edge> edges = new LinkedList<>();
	
	Vertex(int index, int cost){
		this.index = index;
		this.cost = cost;
	}
	
	public void addEdge(Edge e){
		this.edges.add(e);
	}

	@Override
	public int compareTo(Vertex v){
		return this.cost - v.cost; 
	}
}





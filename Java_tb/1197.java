import java.util.*;
import java.io.*;



class Main{

	static int V, E;	// V : The number of nodes, E : The number of edges
	static int[] parents = null;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		//
		parents = new int[V+1];
		for(int i = 1; i<= V; i++)
			parents[i] = i;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for(int i = 0; i<E; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			pq.add(new Edge(from, to, cost));
		}

		// END OF INIT
		
		long ret = 0;
		int count = 0;
		while(count != V-1){
			Edge tempEdge = pq.poll();

			int from = tempEdge.from;
			int to = tempEdge.to;

			if(findParent(from) == findParent(to))
				continue;

			ret += tempEdge.cost;
			union(from, to);
			count++;
		}

		System.out.println(ret);

	}

	static int findParent(int index){
		if(parents[index] == index)
			return index;
		return parents[index] = findParent(parents[index]);
	}

	static int union(int a, int b){
		int p1 = findParent(a);
		int p2 = findParent(b);

		return parents[p1] = p2;
	}
}

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int cost;

	Edge(int from, int to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o){
		return this.cost - o.cost;
	}
}

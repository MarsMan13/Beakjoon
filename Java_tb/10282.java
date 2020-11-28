import java.util.*;
import java.io.*;


class Main{
	
	final static int INF = 1000000000;

	static int T;
	static int n, d, c;
	static LinkedList<Edge>[] edges = null;
	static int[] visited = null;
	static int[] dist = null;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		T = Integer.parseInt(st.nextToken());

		for(int t = 0; t<T; t++){

			st = new StringTokenizer(bf.readLine());

			n = Integer.parseInt(st.nextToken());	// The number of Computers
			d = Integer.parseInt(st.nextToken());	// The number of Dipendencies
			c = Integer.parseInt(st.nextToken());	// The Index of the hacked Computer
			
			edges = new LinkedList[n+1];
			visited = new int[n+1];
			visited[c] = 1;
			dist = new int[n+1];
			for(int i = 1; i<=n; i++){
				dist[i] = INF;
			}
			dist[c] = 0;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();

			for(int i = 0; i<d; i++){
				st = new StringTokenizer(bf.readLine());
				
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
			
				if(edges[from] == null)
					edges[from] = new LinkedList<Edge>();
				if(from == c){
					dist[to] = distance;
					pq.add(new Edge(to, distance));
				}
				edges[from].add(new Edge(to, distance));
			}
			// END OF INIT

			while(!pq.isEmpty()){
				Edge tempEdge = pq.poll();
			
				int temp = tempEdge.target;
				if(visited[temp] == 1 || edges[temp] == null){
					continue;
				}
				for(Edge forEdge : edges[temp]){
					if(visited[forEdge.target] == 0 && dist[temp] + forEdge.cost < dist[forEdge.target]){
						dist[forEdge.target] = dist[temp] + forEdge.cost;
						pq.add(new Edge(forEdge.target, dist[forEdge.target]));
					}
				}
				visited[temp] = 1;
			}
			
			int hackedComNum = 0;
			int maxSec = 0;
			for(int i = 1; i<=n; i++){
				if(dist[i] < INF){
					hackedComNum++;	
					if(maxSec < dist[i])
						maxSec = dist[i];
				}
			}
			bw.write(hackedComNum+" "+maxSec+"\n");
		}
		bw.flush();
		bw.close();
		bf.close();

		
	}
		
}

class Edge implements Comparable<Edge>{

	int target;
	int cost;

	Edge(int target, int cost){
		this.target = target;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o){
		return this.cost - o.cost;
	}
}

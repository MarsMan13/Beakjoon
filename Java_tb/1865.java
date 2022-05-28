import java.util.*;
import java.io.*;



class Main{
	

	static int N, M, W;
	static int[] timeTable = null;
	static List<Edge> edges = null;
	static List<Edge> holeEdges = null;
	static int INF = 5000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	// The number of points
			M = Integer.parseInt(st.nextToken());	// The number of roads
			W = Integer.parseInt(st.nextToken());	// The number of holes
			
			timeTable = new int[N+1];
			for(int i = 0; i<=N; i++)
				timeTable[i] = INF; 
			edges = new ArrayList<>(M+W+2);
			holeEdges = new ArrayList<>(W+2);
			for(int m = 0; m<M; m++){
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				edges.add(new Edge(from, to, time));
			}
			for(int w = 0; w<W; w++){
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				Edge tempEdge = new Edge(from, to, time * -1);
				tempEdge.reversable = 0;
				edges.add(tempEdge);
				holeEdges.add(tempEdge);
			}
			int flag = 0;
			flag = bellman_ford(1);
			if(flag == 0)
				sb.append("NO\n");
			else
				sb.append("YES\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
		
	}

	public static int bellman_ford(int start){
		timeTable[start] = 0;
		for(int i = 0; i<N-1; i++){
			for(Edge e : edges){
				int from = e.from;
				int to = e.to;
				if(timeTable[from] + e.time < timeTable[to])
					timeTable[to] = timeTable[from] + e.time;
				if(e.reversable == 0){
					continue;
				}
				from = e.to;
				to = e.from;
				if(timeTable[from] + e.time < timeTable[to])
					timeTable[to] = timeTable[from] + e.time;
			}
		}
		for(Edge e : edges){
			int from = e.from;
			int to = e.to;
			if(timeTable[from] + e.time < timeTable[to])
				return 1;
			if(e.reversable == 0){
				continue;
			}
			from = e.to;
			to = e.from;
			if(timeTable[from] + e.time < timeTable[to])
				return 1;
		}
		return 0;
			
	}
}

class Edge{
	
	int from, to, time;
	int reversable = 1;
	Edge(int from, int to, int time){
		this.from = from; this.to = to; this.time = time;
	}
}
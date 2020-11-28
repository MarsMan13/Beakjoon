import java.util.*;
import java.io.*;



class Main{

	final static int INF = 1000000000;
	static int N, M, X;
	static int[][] edges = null;

	public static void main throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		edges = new int[N+1][N+1];

		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int from =  Integer.parseInt(st.nextToken());
			int to =  Integer.parseInt(st.nextToken());
			int from =  Integer.parseInt(st.nextToken());


		}

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

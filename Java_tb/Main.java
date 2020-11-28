import java.util.*;
import java.io.*;

public class Main{


	static int N;
	static int M;
	static int C;
	static LinkedList<Integer>[] edges;
	static int[] color;

	public static void main(String[] args) throws Exception{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		color = new int[N+1];
		edges = new LinkedList[N+1];
		for(int i = 1; i<=N; i++){
			edges[i] = new LinkedList<Integer>();
		}

		st = new StringTokenizer(bf.readLine(), " ");
		int i = 1;
		while(st.hasMoreTokens()){
			color[i++] = Integer.parseInt(st.nextToken());
		}

		for(i = 0; i<N-1; i++){
			st = new StringTokenizer(bf.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges[from].add(to);
		}
	
		// END OF INIT


		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine(), " ");

			
		}

	}

	static int[] bfs(int index){
		if(edges[index].size() == 0)	return null;
		
		int root = index;



	}
}
/*
class Node{

	int index;
	int color;
	LinkedList<Node> childs = new LinkedList<>();
	int[] childColor = new int[Main.color];

	Node(int index, int color){
		this.index = index;
		this.color = color;
	}
}
*/

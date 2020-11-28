import java.util.*;
import java.io.*;


class Main{


	static int count = 0;
	static LinkedList<Integer>[] edges;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		edges = new LinkedList[n+1];
		visited = new boolean[n+1];

		StringTokenizer st;
		int edge1, edge2;
		for(int i = 0; i<n-1; i++){	
			st = new StringTokenizer(bf.readLine());
			edge1 = Integer.parseInt(st.nextToken());
			edge2 = Integer.parseInt(st.nextToken());

			if(edges[edge1] == null)
				edges[edge1] = new LinkedList<Integer>();
			if(edges[edge2] == null)
				edges[edge2] = new LinkedList<Integer>();

			edges[edge1].add(edge2);
			edges[edge2].add(edge1);
		}
	
		visited[1] = true;
		preSearching(1, 0);
		
		if(count%2 == 0){
			System.out.println("No");
		}
		else{
			System.out.println("Yes");
		}
	}

	static void preSearching(int index, int depth){
		int childNum = 0;
		for(Iterator<Integer> itr = edges[index].iterator(); itr.hasNext(); ){
			int edge = itr.next();
			if(visited[edge] == false){
				visited[edge] = true;
				preSearching(edge, depth+1);
				childNum++;
			}
		}
		if(childNum == 0){
			//System.out.println("Leef node's index: "+index+" and its depth: "+depth);
			Main.count += depth;
		}
		return;
	}
}

import java.util.*;
import java.io.*;


class Main{
	
	static int n;
	static Node[] nodes = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(bf.readLine());
		nodes = new Node[n+1];	
		for(int i = 0; i<n-1; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(nodes[parent] == null)
				nodes[parent] = new Node(parent);
			if(nodes[chlid] == null)
				nodes[child] = new Node(child);
			nodes[parent].child.add(nodes[child]);
			nodes[child].cost = cost;
		}
		// END OF INIT
		
		
	}
	
	public static void dfs(int index, int length);
}

class Node{
	int index;
	int cost = 0;
	List<Node> child = new LinkedList<>();
	Node(int index){
		this.index = index;
	}
}
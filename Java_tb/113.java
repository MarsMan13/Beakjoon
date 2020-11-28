import java.util.*;
import java.io.*;


class Main{

	static int N;
	static Node[] nodes;
	static Edge[] edges;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		nodes = new Node[N+10];
		edges = new Edge[N+10];
		StringTokenizer st = null;
		int a;
		int b;
		for(int i = 1; i<=N-1; i++){
			st = new StringTokenizer(bf.readLine());
	
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if(nodes[a] == null){
				nodes[a] = new Node(a);
			}
			if(nodes[b] == null){
				nodes[b] = new Node(b);
			}
			
			nodes[a].child.add(nodes[b]);
			nodes[b].child.add(nodes[a]);

			edges[i] = (new Edge(nodes[a], nodes[b]));
		}

		long Zee = 0;
		Node tempNode = null;
		for(int i = 1; i<=N; i++){
			tempNode = nodes[i];
			if(3 <= tempNode.child.size()){
				int r = tempNode.child.size();
				Zee += ((r * (r - 1) * (r - 2))/6);
			}
		}

		long Lee = 0;
		Edge tempEdge = null;
		for(int i = 1; i<=N-1; i++){
			tempEdge = edges[i];
			Lee += ((tempEdge.left.child.size() -1) * (tempEdge.right.child.size() -1));
		}


		if(Lee == (Zee * 3)){
			System.out.println("DUDUDUNGA");
		}
		else if(Lee < (Zee * 3)){
			System.out.println("G");
		}
		else{
			System.out.println("D");
		}

	}
}

class Node{
	int index;
	LinkedList<Node> child = new LinkedList<>();

	Node(int i){
		this.index = i;
	}
}

class Edge{
	Node left;
	Node right;

	Edge(Node left, Node right){
		this.left = left;
		this.right = right;
	}
}

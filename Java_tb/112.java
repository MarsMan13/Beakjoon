import java.util.*;
import java.io.*;



class Main{

	static int N = 0;
	static int[] combi = null;
	static Node[] nodes = null;
	static LinkedList<Edge> edges = new LinkedList<>();

	public static void main(String[] args) throws IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		nodes = new Node[N+1];
		combi = new int[2*N];
		StringTokenizer st = null;
		int i;
		int j;
		for(int c = 0; c<N-1; c++){

			st = new StringTokenizer(bf.readLine());
		
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			if(nodes[i] == null)
				nodes[i] = new Node(i);
			if(nodes[j] == null)
				nodes[j] = new Node(j);
			
			nodes[i].child.add(nodes[j]);
			nodes[i].childNum += 1;

			nodes[j].child.add(nodes[i]);
			nodes[j].childNum += 1;

			edges.add(new Edge(nodes[i], nodes[j]));
		}

		// END OF INIT
		//


		// FOR ZEE
		long Zee = 0;
		for(i = 1; i<=N; i++){
			if(3 <= nodes[i].childNum){
				int r = nodes[i].childNum;
				if(combi[r] == 0){
					combi[r] = ((r * (r-1) * (r-2)) / 6);
				}
				Zee += combi[r];
			}
		}
		
		// FOR LEE
		long Lee = 0;
		Edge tempEdge = null;
		for(Iterator<Edge> itr = edges.iterator(); itr.hasNext();){
			tempEdge = itr.next();
			Lee += ((tempEdge.left.childNum - 1) * (tempEdge.right.childNum - 1));
		}


		// END OF PROCESS
		//


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
	int childNum = 0;

	Node(int i){
		this.index = i;
	}
}

class Edge{

	Node left;
	Node right;

	Edge(Node a, Node b){
		this.left = a;
		this.right = b;
	}

	@Override
	public String toString(){
		return "left: "+left.index +" right: "+right.index;
	}
}

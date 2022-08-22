import java.util.*;
import java.io.*;

class Main{
	static int N, R;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	R = Integer.parseInt(st.nextToken());
		Node.nodes = new Node[N+1];
		for(int i = 1; i<=N; i++)	Node.nodes[i] = new Node(i);

		for(int i = 0; i<N-1; i++){
			st = new StringTokenizer(bf.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			Node.nodes[node1].addNode(Node.nodes[node2], weight);
			Node.nodes[node2].addNode(Node.nodes[node1], weight);
		}
		// END OF INIT
		dfs(R, -1, 0);
		System.out.println(maxColumn+" "+maxLeaf);
	}
	static boolean columnCheck = false;
	static int maxLeaf = 0;
	static int maxColumn = 0;

	public static void dfs(int index, int fromIndex, int length){
		Node curNode = Node.nodes[index];
		if(!columnCheck){
			maxColumn = length;
			if(curNode.addjNodes.size() >= 3 || (fromIndex == -1 && curNode.addjNodes.size() >= 2)){
				columnCheck = true;
			}
		}
		int paths = 0;;
		for(int i = 0; i<curNode.addjNodes.size(); i++){
			Node tempNode = curNode.addjNodes.get(i);
			int tempWeight = curNode.addjWeights.get(i);
			if(tempNode.index == fromIndex)	continue;

			dfs(tempNode.index, index, length + tempWeight);
			paths++;
		}
		if(paths == 0){
			maxLeaf = Math.max(maxLeaf, length-maxColumn);
		}	
	}
}

class Node{
	static Node[] nodes = null;

	int index;
	List<Node> addjNodes = new ArrayList<>();
	List<Integer> addjWeights = new ArrayList<>();

	Node(int index){
		this.index = index;
	}

	void addNode(Node e, int weight){
		this.addjNodes.add(e);
		this.addjWeights.add(weight);
	}
}
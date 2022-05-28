import java.util.*;
import java.io.*;


class Main{
	
	static int n;
	static Node[] nodes = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		n = Integer.parseInt(bf.readLine());
		nodes = new Node[n+1];	
		nodes[1] = new Node(1);
		for(int i = 0; i<n-1; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(nodes[parent] == null)
				nodes[parent] = new Node(parent);
			if(nodes[child] == null)
				nodes[child] = new Node(child);
			nodes[parent].addChild(nodes[child]);
			nodes[child].cost = cost;
		}
		// END OF INIT
	
		dfs(1);
		
		int max = 0;
		for(int i = 1; i<=n; i++){
			Node curNode = nodes[i];
			if(curNode.child.size() == 0)
				continue;
			else if(curNode.child.size() == 1){
				if(max < curNode.childLength.get(0))
					max = curNode.childLength.get(0);
			}
			else{
				Collections.sort(curNode.childLength, Collections.reverseOrder());
				if(max < curNode.childLength.get(0) + curNode.childLength.get(1))
					max = curNode.childLength.get(0) + curNode.childLength.get(1);
			}
		}
		System.out.println(max);
		
	}
	public static int dfs(int index){
		Node curNode = nodes[index];
	
		int max = 0;
		for(int i = 0; i<curNode.child.size(); i++){
			curNode.childLength.set(
				i, dfs(curNode.child.get(i).index) + curNode.child.get(i).cost
			);
			if(max < curNode.childLength.get(i))
				max = curNode.childLength.get(i);
		}
		return max;
	}
}

class Node{
	int index;
	int cost = 0;
	List<Node> child = new ArrayList<>();
	List<Integer> childLength = new ArrayList<>();
	Node(int index){
		this.index = index;
	}
	
	public void addChild(Node c){
		this.child.add(c);
		this.childLength.add(0);
	}
}
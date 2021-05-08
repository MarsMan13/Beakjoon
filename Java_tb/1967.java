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
			if(nodes[child] == null)
				nodes[child] = new Node(child);
			nodes[parent].addChild(nodes[child]);
			nodes[child].cost = cost;
		}
		// END OF INIT
	
		dfs(1);
		
		int max = -1;
		for(int i = 1; i<=n; i++){
			Node curNode = nodes[i];
			if(curNode.child.size() == 0)
				continue;
			else if(curNode.child.size() == 1){
				System.out.println("index: "+curNode.index+", max: "+curNode.childLength.get(0));
				if(max == -1 || max < curNode.childLength.get(0))
					max = curNode.childLength.get(0);
			}
			else{
				Collections.sort(curNode.childLength, Collections.reverseOrder());
				if(max == -1 || max < curNode.childLength.get(0) + curNode.childLength.get(1))
					max = curNode.childLength.get(0) + curNode.childLength.get(1);
				System.out.println("index: "+curNode.index+", max: "+curNode.childLength.get(0) + curNode.childLength.get(1));
			}
		}
		System.out.println(max);
		
	}
	public static int dfs(int index){
		Node curNode = nodes[index];
	
		int max = 0;
		for(int i = 0; i<curNode.child.size(); i++){
			curNode.childLength.add(
				i, dfs(curNode.child.get(i).index) + curNode.child.get(i).cost
			);		
			if(max < curNode.childLength.get(i))
				max = curNode.childLength.get(i);
		}
		for(int i : curNode.childLength){
			System.out.println(i);
		}
		return max;
	}
}

class Node{
	int answer = 0;
	int index;
	int cost = 0;
	List<Node> child = new ArrayList<>(2);
	List<Integer> childLength = new ArrayList<>(2);
	Node(int index){
		this.index = index;
	}
	
	public void addChild(Node c){
		this.child.add(c);
		this.childLength.add(0);
	}
}
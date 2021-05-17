import java.util.*;
import java.io.*;


class Main{
	
	static List<Integer> inputs = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		while(true){
			String line = bf.readLine();
			if(line == null || line.equals(""))
				break;
			inputs.add(Integer.parseInt(line));
		}

		// END OF INIT
		
		if(0 < inputs.size()){
			int index = inputs.get(0);
			Node root = new Node(index);
			def1(root, 1, inputs.size()-1);
			postOrder(root);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();	bw.close();
		
	}
	
	public static void postOrder(Node node){
		if(node.leftChild != null)
			postOrder(node.leftChild);
		if(node.rightChild != null)
			postOrder(node.rightChild);
		sb.append(node.index);	sb.append("\n");
	}
	
	public static void def1(Node node, int start, int end){
		int leftChildIndex = -1;
		int rightChildIndex = -1;
	
		if(end < start)
			return;
		
		for(int i = start; i<=end && (leftChildIndex == -1 || rightChildIndex == -1); i++){
			if(leftChildIndex == -1 && inputs.get(i) < node.index)
				leftChildIndex = i;
			if(rightChildIndex == -1 && node.index < inputs.get(i))
				rightChildIndex = i;
		}
		if(leftChildIndex != -1){
			node.leftChild = new Node(inputs.get(leftChildIndex));
			if(rightChildIndex != -1)
				def1(node.leftChild, leftChildIndex+1, rightChildIndex-1);
			else
				def1(node.leftChild, leftChildIndex+1, end);
		}
		if(rightChildIndex != -1){
			node.rightChild = new Node(inputs.get(rightChildIndex));
			def1(node.rightChild, rightChildIndex+1, end);
		}
	}
}

class Node{
	int index;
	Node leftChild = null, rightChild = null;
	Node(int index){
		this.index = index;
	}
	
	public void addLeftChild(Node c){
		this.leftChild = c;
	}
	
	public void addRightChild(Node c){
		this.rightChild = c;
	}
}
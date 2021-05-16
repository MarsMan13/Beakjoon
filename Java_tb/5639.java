import java.util.*;
import java.io.*;


class Main{
	
	static List<Integer> inputs = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		while(true){
			String line = bf.readLine();
			if(line == null || line.equals(""))
				break;
			inputs.add(Integer.parseInt(line));
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
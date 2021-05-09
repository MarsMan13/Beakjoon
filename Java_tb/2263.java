import java.util.*;
import java.io.*;


class Main{
	
	static Node root = null;
	static int in_index = 0;
	static int post_index = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] inorder = new int[n+1];
		int[] postorder = new int[n+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++)
			inorder[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++)
			postorder[i] = Integer.parseInt(st.nextToken());
		// END OF INIT
		
		root = new Node();
		def(root);
		
	}
	
	public static void def(Node node){
		visit(node, 0);			//pre-order
		if(node.left != null)
			def(node.left);
		visit(node, 1);			//in-order
		if(node.right != null)
			def(node.right);
		visit(node, 2);			//post-order
		
	}
	
	public static void visit(Node node, int mode){
		//mode : 0 --> pre, 1 --> in, 2 --> post
		
	
	}
}


class Node{
	
	int index;
	Node left = null;
	Node right = null;	
}
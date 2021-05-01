import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack_by_me stack = new Stack_by_me();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String command = st.nextToken();
			switch(command){
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "top":
					sb.append(stack.top());
					sb.append("\n");
					break;
				case "size":
					sb.append(stack.size());
					sb.append("\n");
					break;
				case "empty":
					sb.append(stack.empty());
					sb.append("\n");
					break;
				case "pop":
					sb.append(stack.pop());
					sb.append("\n");
					break;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

class Stack_by_me{
	
	int size = 0;
	Node top = null;
	
	public void push(int n){
		Node newNode = new Node(n);
		newNode.next = top;
		this.top = newNode;
		this.size += 1;
	}
	
	public int pop(){
		if(this.size() == 0)
			return -1;
		Node ret = this.top;
		this.top = ret.next;
		this.size -= 1;
		return ret.n;
	}
	
	public int size(){
		return this.size;
	}
	
	public int empty(){
		if(size() == 0)
			return 1;
		return 0;
	}
	
	public int top(){
		if(this.top == null)
			return -1;
		return this.top.n;
	}
}

class Node{
	
	int n;
	Node next = null;
	
	Node(int n){
		this.n = n;
	}
}
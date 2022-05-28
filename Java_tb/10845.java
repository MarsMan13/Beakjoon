import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		MyQueue queue = new MyQueue();
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			String command = st.nextToken();
			
			switch(command){
				case "push":
					queue.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(queue.pop());
					sb.append("\n");
					break;
				case "size":
					sb.append(queue.size());
					sb.append("\n");
					break;
				case "empty":
					sb.append(queue.empty());
					sb.append("\n");
					break;
				case "front":
					sb.append(queue.front());
					sb.append("\n");
					break;
				case "back":
					sb.append(queue.back());
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


class MyQueue{

	Node front = null;
	Node last = null;
	int size = 0;
	
	public void push(int n){
		Node newNode = new Node(n);
		if(last != null)
			last.next = newNode;
		last = newNode;
		if(front == null)	
			front = last;
		size++;
	}
	
	public int pop(){
		if(size() == 0)
			return -1;
		Node ret = front;
		front = front.next;
		size--;
		if(size() == 0)
			last = front;
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
	
	public int front(){
		if(front == null)
			return -1;
		return front.n;
	}
	
	public int back(){
		if(last == null)
			return -1;
		return last.n;
	}
}

class Node{
	int n;
	Node next = null;
	
	Node(int n){
		this.n = n;
	}
}
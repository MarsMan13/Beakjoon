import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		MyDeque deque = new MyDeque();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			String command = st.nextToken();
			switch(command){
				case "push_back":
					deque.push_back(Integer.parseInt(st.nextToken()));
					break;
				case "push_front":
					deque.push_front(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					sb.append(deque.pop_front());
					sb.append("\n");
					break;
				case "pop_back":
					sb.append(deque.pop_back());
					sb.append("\n");
					break;
				case "front":
					sb.append(deque.front());
					sb.append("\n");
					break;
				case "back":
					sb.append(deque.back());
					sb.append("\n");
					break;
				case "size":
					sb.append(deque.size());
					sb.append("\n");
					break;
				case "empty":
					sb.append(deque.empty());
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

class MyDeque{

	Node front = null;
	Node back = null;
	int size = 0;
	
	public void push_front(int n){
		Node newNode = new Node(n);
		if(front != null)
			front.before = newNode;
		newNode.after = front;
		front = newNode;
		if(back == null)
			back = front;
		size++;
	}
	
	public void push_back(int n){
		Node newNode = new Node(n);
		if(back != null)
			back.after = newNode;
		newNode.before = back;
		back = newNode;
		if(front == null)
			front = back;
		size++;
	}
	
	public int pop_front(){
		Node ret = front;
		if(front == null)
			return -1;
		front = front.after;
		if(front != null)
			front.before = null;
		if(back == ret)
			back = front;
		size--;
		return ret.n;
	}
	
	public int pop_back(){
		Node ret = back;
		if(back == null)
			return -1;
		back = back.before;
		if(back != null)
			back.after = null;
		if(front == ret)
			front = back;
		size--;
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
		if(back == null)
			return -1;
		return back.n;
	}
}

class Node{
	
	Node before = null;
	Node after = null;
	int n;
	
	Node(int n){
		this.n = n;
	}
}
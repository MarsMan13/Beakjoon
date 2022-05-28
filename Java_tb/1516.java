import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static Node[] nodes = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N+1];
		for(int i = 1; i<=N; i++)	nodes[i] = new Node(i);
		
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			//
			int tempTime = Integer.parseInt(st.nextToken());
			nodes[i].time = tempTime;
			
			while(true){
				int temp = Integer.parseInt(st.nextToken());
				if(temp == -1)
					break;
				nodes[i].addFather(nodes[temp]);
			}
			//
		}
		//
		for(int i = 1; i<=N; i++){
			if(nodes[i].result == 0){
				def(i);
			}
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++){
			sb.append(nodes[i].result);	sb.append("\n");	
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	static void def(int index){
		Node cur = nodes[index];
		for(Iterator<Node> itr = cur.father.iterator(); itr.hasNext();){
			Node temp = itr.next();
			if(temp.result == 0)
				def(temp.index);
			if(cur.result < temp.result)
				cur.result = temp.result;
		}
		cur.result += cur.time;
	}
}

class Node{
	int index;
	int time;
	int result = 0;
	List<Node> father = new LinkedList<>();
	
	Node(int index){
		this.index = index;
	}
	
	public void addFather(Node f){
		this.father.add(f);
	}
}








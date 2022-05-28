import java.util.*;
import java.io.*;



class Main{
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		Node[] nodes = new Node[N+1];
		
		for(int i = 0; i<N-1; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			if(nodes[node1] == null)
				nodes[node1] = new Node(node1);
			if(nodes[node2] == null)
				nodes[node2] = new Node(node2);
			nodes[node1].adj.add(nodes[node2]);
			nodes[node2].adj.add(nodes[node1]);
		}
		// END OF INIT
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(nodes[1]);
		nodes[1].visited = 1;
		while(!(queue.isEmpty())){
			Node temp = queue.poll();
			for(Node next : temp.adj){
				if(next.visited == 0){
					next.parent = temp.index;
					next.visited = 1;
					queue.offer(next);
				}
			}	
		}
		
		// END OF PROCESSING
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i<= N; i++){
			sb.append(nodes[i].parent);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString()); bw.flush(); bw.close(); bf.close();
		
	}
}

class Node{
	
	int index;
	int parent = 0;
	int visited = 0;
	List<Node> adj = new LinkedList<>();
	Node(int index){
		this.index = index;
	}
}







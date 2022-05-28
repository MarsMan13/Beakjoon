import java.util.*;
import java.io.*;


class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		Node[] nodes = new Node[N+1];
		for(int i = 1; i<=N; i++)
			nodes[i] = new Node(i);
		
		for(int m = 0; m<M; m++){
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int before = -1;
			for(int i = 0; i<num; i++){
				int index = Integer.parseInt(st.nextToken());
				if(before != -1 && !(nodes[before].next.contains(nodes[index]))){
					nodes[before].next.add(nodes[index]);
					nodes[index].count++;
				}
				before = index;
			}
		}
		//
		List<Integer> ret = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++){
			if(nodes[i].count == 0)
				queue.offer(i);
		}
		//
		while(!(queue.isEmpty())){
			Node temp = nodes[queue.poll()];
			ret.add(temp.index);
			for(Node node : temp.next){
				node.count--;
				if(node.count == 0)
					queue.offer(node.index);
			}
		}
		//
		if(N != ret.size()){
			System.out.println(0);
		}
		else{
			StringBuilder sb = new StringBuilder();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for(Integer i : ret){
				sb.append(i);	sb.append("\n");
			}
			bw.write(sb.toString());	bw.flush();
			bw.close();
		}
	}
}


class Node{
	int index;
	int count = 0;
	List<Node> next = new ArrayList<>();
	
	Node(int index){
		this.index = index;
	}
}
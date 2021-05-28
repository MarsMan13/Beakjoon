import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	static List<Integer> ret = new ArrayList<>(); 
	static TreeMap<Integer, Node> nodes = new TreeMap<>();
	static int[] visited = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		
		for(int m = 0; m<M; m++){
			st = new StringTokenizer(bf.readLine());
			Node before = null;
			int num = Integer.parseInt(st.nextToken());
			for(int m2 = 0; m2<num; m2++){
				int no = Integer.parseInt(st.nextToken());
				Node temp = null;
				if(nodes.containsKey(no)){
					temp = nodes.get(no);
				}
				else{
					temp = new Node(no);
					nodes.put(no, temp);
				}
				
				if(before != null){
					if(!(before.next.contains(temp))){
						before.next.add(temp);
						temp.count++;
					}
				}
				before = temp;
			}
		}
		//
		PriorityQueue<Node> pq = new PriorityQueue<>(nodes.values());	

		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			if(temp.count != 0){
				System.out.println(0);
				System.exit(0);
			}
			ret.add(temp.no);
			for(Node node : temp.next){
				pq.remove(node);
				node.count--;
				pq.offer(node);
			}
		}
		
		//
	
		StringBuilder sb = new StringBuilder();
		for(Integer i : ret){
			sb.append(i);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}

class Node implements Comparable<Node>{
	
	int no;
	int count = 0;
	List<Node> next = new ArrayList<Node>();

	Node(int no){
		this.no = no;
	}
	
	@Override
	public int compareTo(Node o){
		return this.count - o.count;
	}
}

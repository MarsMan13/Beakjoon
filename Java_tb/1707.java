import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k<K; k++){
			st = new StringTokenizer(bf.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			Node[] nodes = new Node[V+1];
			for(int i = 1; i<=V; i++)
				nodes[i] = new Node(i);
			for(int e = 0; e<E; e++){
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				nodes[from].adjs.add(to);
				nodes[to].adjs.add(from);
			}
			// END OF INIT
			boolean result = true;	// result is true, then It can be binary ~.
			OUTER: 
			for(int i = 1; i<=V; i++){	// 그래프가 복수 개일 수 있음.
				if(nodes[i].visited != 0)	continue;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(i);
				nodes[i].visited = 1;	// visited를 색칠하는 용도로 사용함. visited = 1 or -1 색을 가짐.
				while(!queue.isEmpty()){
					Node curNode = nodes[queue.poll()];
					for(int j : curNode.adjs){
						Node targetNode = nodes[j];
						if(targetNode.visited == 0){
							targetNode.visited = curNode.visited * -1;
							queue.offer(j);
						}
						else if(targetNode.visited == curNode.visited){	// 만약 인접노드와 나의 색깔이 같으면, Fail!
							result = false;
							break OUTER;
						}
					}
				}
			}
			// END OF PROCESS
			sb.append(result ? "YES" : "NO");
			sb.append("\n");
		}	
		System.out.println(sb.toString());
	}
	
}

class Node{
	int index;
	int visited = 0;
	List<Integer> adjs = new ArrayList<>();
	
	Node(int index){
		this.index = index;
	}
}
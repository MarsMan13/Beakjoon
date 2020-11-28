import java.util.*;
import java.io.*;


class Main{

	static int V;
	static LinkedList<Edge>[] graph = null;
	static int[] visited = null;
	
	static int ret = 0;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		V = Integer.parseInt(st.nextToken());
	
		graph = new LinkedList[V+2];
		visited = new int[V+1];	
		for(int i = 1; i<=V; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			graph[from] = new LinkedList<Edge>();
			while(true){
				int temp1 = Integer.parseInt(st.nextToken());
				if(temp1 == -1){
					break;
				}
				int temp2 = Integer.parseInt(st.nextToken());
				graph[from].add(new Edge(from, temp1, temp2));
			}
		}
	
		dfs(1, 0);
		System.out.println(ret);

		// END OF INIT
	}

	static int dfs(int index, int upperValue){
		int[] tripple = new int[]{0, 0, 0};
		tripple[2] = upperValue;
		
		visited[index] = 1;
		int maxLength = 0;
		for(Iterator<Edge> itr = graph[index].iterator(); itr.hasNext(); ){
			Edge tempEdge = itr.next();
			if(visited[tempEdge.b] == 1) continue;
			tripple[0] = dfs(tempEdge.b, upperValue+tempEdge.weight) + tempEdge.weight;
			if(maxLength < tripple[0]){
				maxLength = tripple[0];
			}
			Arrays.sort(tripple);
		}

		if(ret < (tripple[1] + tripple[2])){
			ret = (tripple[1] + tripple[2]);
		}

		return maxLength;

	}
}

class Edge{

	int a;
	int b;
	int weight;

	Edge(int a, int b, int weight){
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	@Override
	public String toString(){
		return this.a +"<--"+this.weight+"-->"+this.b;
	}
}

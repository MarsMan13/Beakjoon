import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;


class Main{

	static LinkedList<Edge> edges = new LinkedList<>();
	static int[] parents;


	public static void main(String[] args) throws Exception{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] temps = bf.readLine().split(" ");
		
		int N = Integer.parseInt(temps[0]);
		int M = Integer.parseInt(temps[1]);

		parents = new int[N+1];
		for(int i = 0; i<=N; i++)
			parents[i] = i;

		for(int i = 0; i<M; i++){
			temps = bf.readLine().split(" ");
			edges.add(new Edge(Integer.parseInt(temps[0]), Integer.parseInt(temps[1]), Integer.parseInt(temps[2])));

		}

		// END OF INIT
		Collections.sort(edges);

		N--;
		int cost = 0;
		int weight = 0;
		int max = -1;
		for(Iterator<Edge> itr = edges.iterator(); itr.hasNext(); ){
			if(N == 0) break;
			Edge temp = itr.next();
			int left = temp.left;
			int right = temp.right;
			weight = temp.weight;

			if(sameParent(left, right))	continue;
			
		//	System.out.println(left+" "+right+" "+weight);
			cost += weight;
			unionParent(left, right);
			N--;
		}

		System.out.println(cost - weight);


	}

	static int findParent(int index){
		if(index == parents[index])	return index;
		return parents[index] = findParent(parents[index]);
	}

	static void unionParent(int a, int b){
		a = findParent(a);
		b = findParent(b);
		if(a < b)	parents[b] = a;
		else		parents[a] = b;
	}

	static boolean sameParent(int a, int b){
		return findParent(a) == findParent(b);
	}
}

class Edge implements Comparable<Edge>{

	int left;
	int right;
	int weight;

	Edge(int left, int right, int weight){
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o){
		return this.weight - o.weight;
	}
}

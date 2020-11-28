
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;



public class Main{

	static int N;
	static TestCase[] testCase;

	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		testCase = new TestCase[N];

		for(int i = 0; i<N; i++){
			int n = input.nextInt();
			int d = input.nextInt();
			int c = input.nextInt();
			testCase[i] = new TestCase(n, d, c);
		}

		for(int i = 0; i<N; i++){
			System.out.println(testCase[i].totCount+" "+testCase[i].totTime);
		}
		
	}

}

class TestCase{

	int n, d, c;
	public int totTime;
	public int totCount;
	LinkedList<Edge>[] graph;
	
	int[] results;
	int[] visited;

	@SuppressWarnings("unchecked")
	public TestCase(int n, int d, int c){

		Scanner input = new Scanner(System.in);

		this.n = n;
		this.d = d;
		this.c = c;

		//check
		graph = new LinkedList[this.n + 10];
		for(int i = 1; i<=n; i++){
			graph[i] = new LinkedList<Edge>();
		}

		for(int i = 0; i<d; i++){
			int to = input.nextInt();
			int from = input.nextInt();
			int weight = input.nextInt();
			graph[from].add(new Edge(to, weight));
		}
		//
		//
		dijkstra(c);

	}

	public void dijkstra(int start){

		results = new int[n+1];
		for(int i = 1; i<=n; i++)	results[i] = -1;

		visited = new int[n+1];
		for(int i = 1; i<=n; i++)	visited[i] = 0;

		//
		//
		//END OF SETTING
		
		results[start] = 0;
		for(int i = 0; i<n ; i++){
			int from = find();
			if(from == 0) break;
			visited[from] = 1;
			
			Iterator<Edge> itr = graph[from].iterator();

			while(itr.hasNext()){
				Edge temp = itr.next();
				if(visited[temp.node] == 0 && (results[temp.node] == -1 || (results[temp.node] > results[from] + temp.weight))){
					results[temp.node] = results[from] + temp.weight;
				}
			}
		}
	
		totTime = -1;
		totCount = 0;
		for(int i = 1; i<= n; i++){
			if(results[i] > totTime){
				totTime = results[i];
			}
			if(results[i] != -1){
				totCount++;
			}
		}

	}

	public int find(){

		int min = -1;
		int ret = 0;
		for(int i = 1; i<= n; i++){
			if(visited[i] == 0){
				if((results[i] != -1) && (min == -1 || results[i] < min)){
					ret = i;
					min = results[i];
				}
			}
		}

		return ret;
	}
}

class Edge{

	public int node;
	public int weight;

	public Edge(int node, int weight){
		this.node = node;
		this.weight = weight;
	}

}

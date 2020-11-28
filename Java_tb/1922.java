import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;



class Main{

	static int[] parents = new int[1001];
	static LinkedList<Edge> edges = new LinkedList<>();


	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		for(int i = 0; i<=1000; i++)
			parents[i] = i;
		
		int comSize = sc.nextInt();
		int edge = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<edge; i++){
			String[] temp = sc.nextLine().split(" ");
			edges.add(new Edge(Integer.parseInt(temp[2]), Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));	
		}

		Collections.sort(edges);

		int cost = 0;
		comSize--;
		for(Iterator<Edge> itr = edges.iterator(); comSize != 0 && itr.hasNext(); ){
			Edge temp = itr.next();
			int w = temp.weight;
			int left = temp.left;
			int right = temp.right;
			
			if(sameParent(left, right)) continue;

			unionParent(left,right);
			cost += w;
			comSize--;
		}

		System.out.println(cost);
	}

	static int getParent(int index){
		if(index == parents[index])	return index;
		return parents[index] = getParent(parents[index]);
	}

	static void unionParent(int a, int b){
		a = getParent(a);
		b = getParent(b);
		if(a < b) parents[b] = a;
		else parents[a] = b;
	}

	static boolean sameParent(int a, int b){
		return getParent(a) == getParent(b);
	}
}

class Edge implements Comparable<Edge>{

	int weight;
	int left;
	int right;

	Edge(int w, int l, int r){
		this.weight = w;
		this.left = l;
		this.right = r;
	}

	@Override
	public int compareTo(Edge o){
		return this.weight - o.weight;
	}
}

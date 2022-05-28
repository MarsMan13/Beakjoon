import java.util.*;
import java.io.*;


class Main{
	
	static int N, K;
	static PriorityQueue<Jewelry> pq = new PriorityQueue<>(Collections.reverseOrder());
	static TreeMap<Integer, Integer> bag = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	K = Integer.parseInt(st.nextToken());
		
		//
		
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq.offer(new Jewelry(m, v));
		}
		for(int i = 0; i<K; i++){
			int m = Integer.parseInt(bf.readLine());
			if(bag.containsKey(m))
				bag.put(m, bag.get(m)+1);
			else
				bag.put(m, 1);
		}
		
		// END OF INIT
		long ret = 0;
		while(!(pq.isEmpty())){
			Jewelry temp = pq.poll();
			if(bag.size() == 0)
				break;
			Integer i = bag.ceilingKey(temp.m);
			if(i != null){
				if(bag.get(i) == 1){
					bag.remove(i);
				}
				else{
					bag.put(i, bag.get(i)-1);
				}
				ret += temp.v;
			}
		}
		System.out.println(ret);
	}
}

class Bag implements Comparable<Bag> {
	
	int m;
	Bag(int m){
		this.m = m;
	}
	
	@Override
	public int compareTo(Bag o){
		return this.m - o.m;
	}
}


class Jewelry implements Comparable<Jewelry>{
	int m, v;
	
	Jewelry(int m, int v){
		this.m = m;	this.v = v;
	}
	
	@Override
	public int compareTo(Jewelry o){
		return this.v - o.v;
	}
}
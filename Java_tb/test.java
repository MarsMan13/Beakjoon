import java.util.*;


class Main{


    public static void main(String[] args){

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(3);
		pq.add(1);
		pq.add(2);
		while(!(pq.isEmpty())){
			System.out.println(pq.poll());
		}
		
	}
}


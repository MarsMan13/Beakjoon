import java.util.*;


class Main{


    public static void main(String[] args){

		
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offerLast(1);
		queue.offerLast(3);
		queue.offerLast(2);
		queue.offerLast(4);
		
		System.out.println(queue.pollFirst());
		System.out.println(queue.pollFirst());
		System.out.println(queue.pollFirst());
		System.out.println(queue.pollFirst());
	}
}


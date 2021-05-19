import java.util.*;

class Main{
	
	static long A, B;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();	B = sc.nextLong();
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(A, 1));
		while(!(queue.isEmpty())){
			Node temp = queue.poll();
			if(temp.value == B){
				System.out.println(temp.count);
				sc.close();
				return;
			}
			if(temp.value * 2 <= B){
				queue.offer(new Node(temp.value * 2, temp.count+1));
			}
			if(10 * temp.value + 1 <= B){
				queue.offer(new Node(10 * temp.value + 1, temp.count+1));
			}
		}
		System.out.println(-1);
		sc.close();
		
	}
}

class Node{
	long value;
	long count;
	Node(long value, long count){
		this.value = value; this.count = count;
	}
}
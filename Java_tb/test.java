import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
	
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		queue.offer(2);
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue);
		return;
	}		
}


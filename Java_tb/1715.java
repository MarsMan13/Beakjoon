import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i = 0; i<N; i++){
			Long temp = Long.parseLong(bf.readLine());
			pq.offer(temp);
		}
		
		// END OF INIT
		long result = 0L;
		while(pq.size() >= 2){
			Long temp = pq.poll() + pq.poll();
			result += temp;
			pq.offer(temp);
		}
		System.out.println(result);	
	}
}
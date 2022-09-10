import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		long H = Long.parseLong(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<N; i++){
			long temp = Long.parseLong(bf.readLine());
			pq.offer(temp);
		}
		// END OF INIT
		int trueCount = -1;
		for(int i = 0; i<T; i++){
			long target = pq.poll();
			if(target < H && trueCount == -1){
				trueCount = i;
			}
			if(1L < target){
				target /= 2;
			}
			pq.offer(target);
		}
		if(trueCount != -1){
			System.out.println("YES");
			System.out.println(trueCount);
		}	
		else{
			boolean flag = true;
			long maxHeight = 0L;
			for(Iterator<Long> itr = pq.iterator(); itr.hasNext(); ){
				long target = itr.next();
				maxHeight = Math.max(maxHeight, target);
				if(H <= target){
					flag = false;
				}
			}
			System.out.println(flag ? "YES" : "NO");
			System.out.println(flag ? T : maxHeight);

		}
		//
	}
}
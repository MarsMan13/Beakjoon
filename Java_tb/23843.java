import java.util.*;
import java.io.*;

class Main{
	
	static int N, M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		// END OF INIT
		int[] concent = new int[M];	// concent(?)
		while(!pq.isEmpty()){
			int device = pq.poll();
			int minIndex = 0;
			int minTime = -1;
			for(int i = 0; i<M; i++){
				if(minTime == -1 || concent[i] < minTime){
					minIndex = i;
					minTime = concent[i];
				}
			}
			concent[minIndex] += device;
		}
		int maxTime = 0;
		for(int i = 0; i<M; i++){
			if(maxTime < concent[i]){
				maxTime = concent[i];
			}
		}
		System.out.println(maxTime);
	}
}
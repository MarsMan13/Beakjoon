import java.util.*;


class Main{
	
	static int N, K;
	static final int MAX = 100000;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	K = sc.nextInt();
		
		int[] time = new int[MAX+1];	Arrays.fill(time, -1);
		int[] count = new int[MAX+1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		count[N] = 1;
		time[N] = 0;
		while(!(queue.isEmpty())){
			int curIndex = queue.poll();
			int curCount = count[curIndex];
			int curTime = time[curIndex];
			
			if(time[K] != -1 && time[K] < curTime)
				break;
			
			int[] nextIndex = new int[]{curIndex - 1, curIndex + 1, curIndex * 2};
			for(int i : nextIndex){
				if(i < 0 || MAX < i)
					continue;
				//
				if(time[i] == -1){
					time[i] = curTime+1;
					queue.offer(i);
				}
				if(time[i] == curTime+1)
					count[i]+=curCount;
			}
		}
		System.out.println(time[K]);
		System.out.println(count[K]);
	}
}
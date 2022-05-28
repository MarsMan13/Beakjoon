import java.util.*;

class Main{
	
	static int MAX = 100000;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	int K = sc.nextInt();
		
		//
		Queue<PosWithTime> queue = new LinkedList<>();
		queue.offer(new PosWithTime(N, 0));
		int[] count = new int[MAX+1];
		int[] time = new int[MAX+1];
		count[N] = 1;
		while(!(queue.isEmpty())){
			PosWithTime curIndex = queue.poll();
			if(time[K] != 0 && time[K] < curIndex.time)
				break;
			if(time[curIndex.index] == 0)
				time[curIndex.index] = curIndex.time;
			int[] nextIndex = new int[]{
				curIndex.index-1, curIndex.index+1, curIndex.index * 2
			};
			for(int i : nextIndex){
				if(i < 1 || MAX < i)
					continue;
				count[i]+=count[curIndex.index];
				if(1 <= count[i] && time[i] == curIndex.time+1){
					continue;
				}
				queue.offer(new PosWithTime(i, curIndex.time+1));
			}
		}
		System.out.println(time[K]);
		System.out.println(count[K]);
	}
}

class PosWithTime{
	int index;
	int time;
	int count;
	PosWithTime(int index, int time, int count){
		this.index = index;	this.time = time;	this.count = count;
	}
}
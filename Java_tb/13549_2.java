import java.util.*;
import java.io.*;


class Main{
	
	static int N, K;
	static final int MAX = 100000;
	static int[] map = new int[MAX+1];	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt();
		int[] p = new int[3];
		Arrays.fill(map, -1);
		map[N] = 0;
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(N, 0));
		outer: while(!(queue.isEmpty())){
			Point curIndex = queue.poll();
			if(curIndex.index == K){
				System.out.println(curIndex.time);
				break outer;
			}
			p[0] = curIndex.index * 2;
			p[1] = curIndex.index - 1;
			p[2] = curIndex.index + 1;
			for(int i = 0; i<3; i++){
				if(0<=p[i] && p[i]<=MAX){
					int nextTime = 0;
					if(i == 0){
						nextTime = curIndex.time;
						if(map[p[i]] == -1 || nextTime < map[p[i]]){
							queue.offer(new Point(p[i], nextTime));
							map[p[i]] = nextTime;
						}
					}
					else{
						nextTime = curIndex.time + 1;
						if(map[p[i]] == -1 || nextTime < map[p[i]]){
							queue.offer(new Point(p[i], nextTime));
							map[p[i]] = nextTime;
						}
					}		
				}
			}
		}
		sc.close();
	}
}

class Point implements Comparable<Point>{
	int index;
	int time = 0;
	Point(int index, int time){
		this.index = index; this.time = time;
	}
	
	@Override
	public int compareTo(Point o){
		return this.time - o.time;
	}
}

import java.util.*;
import java.io.*;


class Main{
	
	static int N, K;
	static final int MAX = 100000;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt();
		if(N == K){
			System.out.println(0);
			sc.close();
			return;
		}
		int[] p = new int[3];
		
		int[] visited = new int[MAX+1];
		Deque<Point> queue = new ArrayDeque<>();
		queue.offerLast(new Point(N, 0));
		outer: while(!(queue.isEmpty())){
			Point curIndex = queue.pollFirst();
			p[2] = curIndex.index + 1;
			p[1] = curIndex.index - 1;
			p[0] = curIndex.index * 2;
			for(int i = 0; i<3; i++){
				if(0<=p[i] && p[i]<=MAX){
					if(visited[p[i]] == 0){
						visited[p[i]] = 1;
						int nextTime = 0;
						if(i == 0){
							nextTime = curIndex.time;
							queue.offerFirst(new Point(p[i], nextTime));
						}
						else
							nextTime = curIndex.time + 1;
							queue.offerLast(new Point(p[i], nextTime));
						if(p[i] == K){
							System.out.println(nextTime);
							break outer;
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


import java.util.*;


class Main{

	static int S;
	static int[][] dp = null;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();	sc.close();
		dp = new int[S+1][S+1];
		//
	
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		queue.offer(new Pair(1, 0, 0));
		dp[1][0] = 1;
		while(!(queue.isEmpty())){
			Pair cur = queue.poll();
			if(cur.i == S){
				System.out.println(cur.c);
				break;
			}
			// option 1
			if(cur.i != cur.j && dp[cur.i][cur.i] == 0){
				dp[cur.i][cur.i] = 1;
				queue.offer(new Pair(cur.i, cur.i, cur.c+1));
			}
			// option 2
			if(cur.i + cur.j <= S && dp[cur.i+cur.j][cur.j] == 0){
				dp[cur.i+cur.j][cur.j] = 1;
				queue.offer(new Pair(cur.i+cur.j, cur.j, cur.c+1));
			}
			// option 3
			if(0 < cur.i-1 && dp[cur.i-1][cur.j] == 0){
				dp[cur.i-1][cur.j] = 1;
				queue.offer(new Pair(cur.i-1, cur.j, cur.c+1));
			}
		}
	}

}

// THIS IS Pair, but not Pair. Sorry.
class Pair implements Comparable<Pair>{
	int i, j, c;
	
	Pair(int i, int j, int c){
		this.i = i;	this.j = j;
		this.c = c;
	}
	
	@Override
	public int compareTo(Pair o){
		return this.c - o.c;
	}
}
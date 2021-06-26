import java.util.*;


class Main{
		
	static int[][] dp = null;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	sc.close();
		dp = new int[1000000][N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		while(!(pq.isEmpty())){
			Node temp = pq.poll();
			if(N < temp.step)	break;
			
		}
	}
	
	static int dfs(int step, int buffer, int cur){

		if(N <= step)
			return cur;
		// if(dp[buffer][step] != -1)
		// 	return dp[buffer][step];
		int ret1 = dfs(step+1, buffer, cur+1);
		int ret2 = dfs(step+2, cur, cur);
		int ret3 = 0;
		if(buffer != 0)
			ret3 = dfs(step+1, buffer, cur+buffer);
		
		int max = Math.max(ret1, Math.max(ret2, ret3));
	
		return dp[buffer][step] = max;
	}
}

class Node implements Comparable<Node>{
	int cur, cb, step;
	Node(int cur, int cb, int step){
		this.cur = cur;	this.cb = cb; this.step = step;
	}
	
	@Override
	public int compareTo(Node o){
		return this.step - o.step;
	}
}
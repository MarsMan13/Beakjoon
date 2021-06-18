import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static Node[] nodes = null;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N+1];
		for(int i = 1; i<=N; i++)	nodes[i] = new Node(i);
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			int time = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			nodes[i].time = time;
			for(int j = 0; j<count; j++){
				int p = Integer.parseInt(st.nextToken());
				nodes[i].addNode(nodes[p]);
			}
		}
		//
		dp = new int[N+1];	Arrays.fill(dp, -1);
		
		for(int i = 1; i<=N; i++){
			if(dp[i] == -1){
				dp[i] = nodes[i].time + dfs(i);
			}
		}
		//
		
		int result = 0;
		for(int i = 1; i<=N; i++)
			if(result < dp[i])
				result = dp[i];
		System.out.println(result);
	}
	
	public static int dfs(int index){
		int max = 0;
		for(Iterator<Node> itr = nodes[index].parent.iterator(); itr.hasNext(); ){
			Node temp = itr.next();
			if(dp[temp.index] == -1)
				dp[temp.index] = temp.time + dfs(temp.index);
			if(max < dp[temp.index])
				max = dp[temp.index];
		}
		return max;
	}
}


class Node{
	int index;
	int time;
	List<Node> parent = new LinkedList<>();
	
	Node(int index){
		this.index = index;
	}
	
	public void addNode(Node c){
		this.parent.add(c);
	}
}
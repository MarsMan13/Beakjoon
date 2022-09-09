import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		Wire[] wires = new Wire[N];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			wires[i] = new Wire(from, to);
		}
		Arrays.sort(wires);
		//
		int max = 0;
		int[] dp = new int[N];
		for(int i = 0; i<N; i++){
			dp[i] = 1;
			for(int j = 0; j<i; j++){
				if(wires[j].to < wires[i].to){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}
}

class Wire implements Comparable<Wire>{
	int from;
	int to;
	Wire(int from, int to){
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(Wire o){
		return this.from - o.from;
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int N, W;
	static Item[] items = null;
	static int[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());	W = Integer.parseInt(st.nextToken());
			items = new Item[N+1];
			for(int i = 1; i<=N; i++){
				st = new StringTokenizer(bf.readLine());
				String item = st.nextToken();
				int V = Integer.parseInt(st.nextToken());
				int needs = Integer.parseInt(st.nextToken());
				items[i] = new Item(item, V, needs);
			}
			dp = new int[N+1][W+1];
			int[][] dp2 = new int[N+1][W+1];	// -1 is stop, 0 is not selected (goto up), positive num is 
			for(int i = 0; i<=N; i++)
				for(int j = 0; j<=W; j++)
					dp2[i][j] = -1;
			for(int i = 1; i<=N; i++){	// items index
				for(int j = 1; j<=W; j++){	// volume max
					dp[i][j] = 0;
					if(items[i].volume <= j){
						dp[i][j] = items[i].needs + dp[i-1][j - items[i].volume];
						dp2[i][j] = items[i].volume;
					}
					if(dp[i][j] < dp[i-1][j]){
						dp[i][j] = dp[i-1][j];
						dp2[i][j] = 0;
					}
				}
			}
			sb.append(dp[N][W]);	sb.append(" ");
			Deque<Integer> queue = new LinkedList<>();
			int count = 0;
			{
				int i = N;	int j = W;
				while(dp2[i][j] != -1){
					if(0 < dp2[i][j]){
						j -= dp2[i][j];
						queue.offerFirst(i);
						count++;
					}
					i--;
				}
			}
			sb.append(count);	sb.append("\n");
			while(!queue.isEmpty()){
				sb.append(items[queue.pollFirst()].name);	sb.append("\n");
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}

class Item{
	String name;
	int volume, needs;
	Item(String name, int volume, int needs){
		this.name = name;
		this.volume = volume;	this.needs = needs;
	}
}
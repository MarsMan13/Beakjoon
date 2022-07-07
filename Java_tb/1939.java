import java.util.*;
import java.io.*;


class Main{

	static Island[] islands = null;
	static final int MAX = 1000000001;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int left = 1;
		int right = 0;
		islands = new Island[N+1];
		for(int i = 1; i<=N; i++)	islands[i] = new Island(i);
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			islands[a].addj.add(b);
			islands[a].weight.add(w);
			islands[b].addj.add(a);
			islands[b].weight.add(w);
			if(right < w)	right = w;
		}
		st = new StringTokenizer(bf.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		// END OF INIT
		int mid = 0;
		while(left <= right){
			mid = (left + right) / 2;
			int flag = 0;
			{
				int[] visited = new int[N+1];
				Queue<Island> queue = new LinkedList<>();
				queue.offer(islands[from]);
				visited[from] = 1;
				while(!queue.isEmpty()){
					Island cur = queue.poll();
					if(cur.index == to)	{
						flag = 1;
						break;
					}
					for(int i = 0; i<cur.addj.size(); i++){
						if(mid <= cur.weight.get(i) && visited[cur.addj.get(i)] == 0){
							visited[cur.addj.get(i)] = 1;
							queue.offer(islands[cur.addj.get(i)]);
						}
					}
				}
			}
			if(flag == 1){
				left = mid+1;
			} 
			else {
				right = mid-1;
			}
		}
		System.out.println(right);
	}
}

class Island{
	int index;
	int w;
	List<Integer> addj = new ArrayList<>(); 
	List<Integer> weight = new ArrayList<>(); 
	Island(int index){
		this.index = index;
	}
}
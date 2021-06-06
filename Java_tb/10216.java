import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int[][] info = null;

	// about Set
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			info = new int[N][3];
			for(int i = 0; i<N; i++){
				st = new StringTokenizer(bf.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());	// x_i
				info[i][1] = Integer.parseInt(st.nextToken());	// y_i
				info[i][2] = Integer.parseInt(st.nextToken());	// R_i
			}
			//
			makeSet(N);
			for(int i = 0; i<N; i++){
				for(int j = i+1; j<N; j++){
					int dx = (info[i][0] - info[j][0]);
					int dy = (info[i][1] - info[j][1]);
					int dMax = (info[i][2] + info[j][2]);
					
					if((dx*dx + dy*dy) <= dMax*dMax){
						union(i, j);
					}
				}
			}
			
			int ret = 0;
			int[] count = new int[N];
			for(int i = 0; i<N; i++){
				int p = find(i);
				if(count[p]++ == 0)
					ret++;
			}
			sb.append(ret);	sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}

	public static int find(int x){
		if(parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y){
		x = find(x);
		y = find(y);
		
		if(rank[x] < rank[y]){
			int temp = x;
			x = y;
			y = temp;
		}
		
		parent[y] = x;
		if(rank[x] == rank[y])
			rank[x]++;
	}
	
	public static void makeSet(int n){
		rank = new int[n];
		parent = new int[n];
		for(int i = 0; i<n; i++)
			parent[i] = i;
	}
}

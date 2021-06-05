import java.util.*;
import java.io.*;


class Main{
	
	static int n, m;
	static int[] parent = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());	m = Integer.parseInt(st.nextToken());
		makeSet(n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int command = Integer.parseInt(st.nextToken());
			int set1 = Integer.parseInt(st.nextToken());
			int set2 = Integer.parseInt(st.nextToken());
			
			if(command == 0)
				union(set1, set2);
			else if(command == 1){
				//
				set1 = find(set1);
				set2 = find(set2);
				if(set1 == set2)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static void union(int x, int y){
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	public static int find(int v){
		if(parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}
	
	public static void makeSet(int n){
		parent = new int[n+1];
		for(int i = 0; i<=n; i++)
			parent[i] = i;
	}
}


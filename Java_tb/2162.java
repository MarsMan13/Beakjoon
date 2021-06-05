import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static Pair[][] lines = null;
	static int[] parent = null;
	static int[] rank = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		lines = new Pair[N+1][3];
		makeSet(N);
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			lines[i][1] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			lines[i][2] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i<=N; i++){
			Pair p1 = lines[i][1];
			Pair p2 = lines[i][2];
			for(int j = i+1; j<=N; j++){
				Pair p3 = lines[j][1];
				Pair p4 = lines[j][2];
				
				int ret1 = Pair.ccw(p1, p2, p3);
				int ret2 = Pair.ccw(p1, p2, p4);
				int ret3 = Pair.ccw(p3, p4, p1);
				int ret4 = Pair.ccw(p3, p4, p2);
				
				int flag = 0;	// 1 --> meet,,,gg
				if(ret1 * ret2 == 0 && ret3 * ret4 == 0){
					if(p1.compareTo(p2) == 1){
						Pair temp = p1;
						p1 = p2;
						p2 = temp;
					}
					if(p3.compareTo(p4) == 1){
						Pair temp = p3;
						p3 = p4;
						p4 = temp;
					}
					//
					if(p1.compareTo(p4) <= 0 && p3.compareTo(p2) <= 0)
						flag = 1;
				}
				else if(ret1 * ret2 <= 0 && ret3 * ret4 <= 0)
					flag = 1;
				
				if(flag == 1){	// if meet
					union(i, j);
				}
			}
		}
	
		int setNum = 0;
		int max = -1;
		int[] count = new int[N+1];
		for(int i = 1; i<=N; i++){
			int realParent = find(i);
			if(count[realParent]++ == 0)
				setNum++;
			if(count[realParent] > max)
				max = count[realParent];
		}
		System.out.println(setNum);
		System.out.println(max);
		
		
	}

	static void union(int x, int y){
		x = parent[x];
		y = parent[y];
		
		if(x == y)
			return;
		
		if(rank[x] > rank[y]){
			int temp = x;	x = y;	y = temp;
		}
		parent[x] = y;
		if(rank[x] == rank[y])
			rank[y]++;
	}
	
	static void makeSet(int n){
		rank = new int[n+1];
		parent = new int[n+1];
		for(int i = 1; i<=n; i++)
			parent[i] = i;
	}
	
	static int find(int v){
		if(parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}
	
}

class Pair implements Comparable<Pair>{
	
	int i, j;

	Pair(int i, int j){
		this.i = i;	this.j = j;
	}
	
	public static int ccw(Pair p1, Pair p2, Pair p3){
		long ret = 1L * (p2.i - p1.i) * (p3.j - p1.j) - 1L * (p3.i - p1.i) * (p2.j - p1.j);
		if(ret > 0L)
			return 1;
		else if(ret < 0L)
			return -1;
		return 0;
	}
	
	@Override
	public int compareTo(Pair p){
		if(this.i == p.i && this.j == p.j)
			return 0;
		else if(this.j < p.j)
			return -1;
		else if(this.j == p.j && this.i < p.i)
			return -1;
		return 1;
	}

}
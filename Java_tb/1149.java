import java.util.*;
import java.io.*;


class Main{
	
	static int N = 0;
	static House[] houses = null;
	static int min = -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		houses = new House[N+1];
		
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int Rcost = Integer.parseInt(st.nextToken());
			int Gcost = Integer.parseInt(st.nextToken());
			int Bcost = Integer.parseInt(st.nextToken());

			houses[i] = new House(Rcost, Gcost, Bcost);
		}
		dfs(0, 0, -1);
		System.out.println(min);
		
	}
	
	public static void dfs(int depth, int tot, int before){
		if(min != -1 && min < tot)
			return;
		House currentHouse = houses[depth];
		for(int i = 0; i<3; i++){
			if(before == i)
				continue;
			tot += currentHouse.rgb[i];
			if(depth+1  < N){
				dfs(depth+1, tot, i);
			}
			else{
				if(min == -1 || tot < min)
					min = tot;
			}
			tot -= currentHouse.rgb[i];
		}
	}
}

class House{
	
	int r, g, b;
	int[] rgb = new int[3];
	House(int r, int g, int b){
		this.r = r; this.g = g; this.b = b;
		rgb[0] = this.r; rgb[1] = this.g; rgb[2] = this.b;
	}
}

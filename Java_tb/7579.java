import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static App[] apps = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		apps = new App[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			apps[i] = new App();
			 apps[i].m = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			apps[i].c = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(apps);
		
		// END OF INIT
	
		int minCost = 10000000* 100 + 1;

		int i = 0;	int j = 0;
		int mSum = 0;	int cSum = 0;
		for(; i<N; i++){
			mSum += apps[i].m;
			cSum += apps[i].c;
			
			for(; j<N && mSum < M ; j++){
				mSum += apps[j].m;
				cSum += apps[j].c;
			}
			
			if(M <= mSum && cSum < minCost)
				minCost = cSum;
			
			mSum -= apps[i].m;
			cSum -= apps[i].c;
		}
		
		System.out.println(minCost);
	}
}

class App implements Comparable<App>{

	int m, c;
	
	@Override
	public int compareTo(App o){
		return this.m - o.m;	
	}
}




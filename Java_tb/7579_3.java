import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static App[] apps = null;
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		apps = new App[N];
		
		int[][] dp = new int[N][M+1];
		
		st = new StringTokenizer(bf.readLine());
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			apps[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		// END OF INIT
	
		for(int i = 0; i<N; i++){
			for(int j = 0; j<=M; j++){
				int ret1 = apps[i].c;
				if(0 <= j-apps[i].m)
					ret1 += dp[i][j-apps[i].m];
				int ret2 = dp[i-1][j];
				
			}
		}
		
	}
}

class App{
	int m, c;
	App(int m, int c){
		this.m = m;	this.c = c;
	}
}
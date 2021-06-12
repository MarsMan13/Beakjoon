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
				int ret1 = -1;
				int ret2 = -1;
				if(0 <= i-1)
					ret1 = dp[i-1][j];
				if(j <= apps[i].m)
					ret2 = apps[i].c;
				else if(0<=i-1 && 0<=dp[i-1][j-apps[i].m]){
					ret2 = apps[i].c + dp[i-1][j-apps[i].m];
				}
				if(0<=ret1 && 0<=ret2)
					dp[i][j] = Math.min(ret1, ret2);
				else if(0<=ret1)
					dp[i][j] = ret1;
				else
					dp[i][j] = ret2;
			}
		}
		System.out.println(dp[N-1][M]);
	}
}

class App{
	int m, c;
	App(int m, int c){
		this.m = m;	this.c = c;
	}
}
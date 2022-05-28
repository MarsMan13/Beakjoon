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
		
		int[][] dp = new int[N][10001];
		
		st = new StringTokenizer(bf.readLine());
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			apps[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		// END OF INIT
	
		for(int i = 0; i<N; i++){
			for(int j = 0; j<=10000; j++){
				int ret1 = 0;
				int ret2 = 0;
				if(0 <= i - 1){
					ret1 = dp[i-1][j];
				}
				if(apps[i].c <= j){
					ret2 = apps[i].m;
					if(0<=i-1 && 0 <= j - apps[i].c)
						ret2 += dp[i-1][j - apps[i].c];
				}
				dp[i][j] = Math.max(ret1, ret2);
			}
		}
		for(int j = 0; j<=10000; j++){
			if(M<=dp[N-1][j]){
				System.out.println(j);
				break;
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
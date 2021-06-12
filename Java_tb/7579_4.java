import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static App[] apps = null;
	static TreeMap[] dp = null;
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		apps = new App[N];
		
		dp = new TreeMap[N];
		for(int i = 0; i<N; i++)	dp[i] = new TreeMap<Integer, Integer>();
		
		st = new StringTokenizer(bf.readLine());
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			apps[i] = new App(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
		}
		// END OF INIT
		
		System.out.println(def(N-1, M));
	}
	
	public static int def(int i, int j){
		int ret1 = -1;
		int ret2 = -1;
		if(0 <= i-1){
			if(dp[i-1].containsKey(j)){
				ret1 = (int)dp[i-1].get(j);
			}
			else{
				ret1 = def(i-1, j);
			}
		}
		if(j <= apps[i].m)
			ret2 = apps[i].c;
		else if(0<=i-1){
			if(dp[i-1].containsKey(j-apps[i].m)){
				ret2 = (int)dp[i-1].get(j - apps[i].m);
			}
			else{
				ret2 = apps[i].c + def(i-1, j - apps[i].m);
			}
		}
		//
		int result = 0;
		if(0<=ret1 && 0<=ret2)
			result = Math.min(ret1, ret2);
		else if(0<=ret1)
			result = ret1;
		else
			result = ret2;
		dp[i].put(j, result);
		return result;
	}
}


class App{
	int m, c;
	App(int m, int c){
		this.m = m;	this.c = c;
	}
}

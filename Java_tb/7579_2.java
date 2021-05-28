import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[] mm = null;
	static int[] cc = null;
	static TreeSet[] dp = null;
	static final MAX = 10000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		mm = new int[N];
		cc = new int[N];
		dp = new TreeSet<Integer, Integer>[N];
		for(int i = 0; i<N; i++){
			dp[i] = new TreeSet<>();
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			mm[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			cc[i] = Integer.parseInt(st.nextToken());
		}
		//
		System.out.println(def(N-1, M));
	}
	
	static int def(int i, int mass){
		
		if(mass <= 0)
			return 0;
		if(i == 0){
			if()
		}
		
		if(!dp[i].containsKey(mass)){
			int ret1 = def(i-1, mass-mm[i]) + cc[i];
			int ret2 = def(i-1, mass);
			if()
			dp[i].put(mass, ret);
		}
		return dp[i].get(mass);	
	}
}


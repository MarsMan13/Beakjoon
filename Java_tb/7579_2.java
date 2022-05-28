import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[] mm = null;
	static int[] cc = null;
	static TreeMap[] dp = null;
	static final int MAX = 10000000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		mm = new int[N];
		cc = new int[N];
		dp = new TreeMap[N];
		for(int i = 0; i<N; i++){
			dp[i] = new TreeMap<Integer, Integer>();
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
		if(i == -1)
			return MAX + 1;
		
		if(!dp[i].containsKey(new Integer(mass))){
			int ret1 = def(i-1, mass-mm[i]) + cc[i];
			int ret2 = def(i-1, mass);
			int ret = ret1;
			if(ret2 < ret)
				ret = ret2;
			dp[i].put(mass, ret);
		}
		return (Integer)dp[i].get(mass);	
	}
}


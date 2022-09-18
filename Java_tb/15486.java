import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static LinkedList[] cc = null;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		cc = new LinkedList[N+1];	dp = new int[N+1];
		for(int i = 1; i<=N; i++)	cc[i] = new LinkedList<Counseling>();
		//
		for(int i = 1; i<=N; i++){
			st = new StringTokenizer(bf.readLine());
			int tempT = Integer.parseInt(st.nextToken());
			int tempP = Integer.parseInt(st.nextToken());
			//
			if(i + tempT - 1 <=N)
				cc[i+tempT-1].add(new Counseling(tempT, tempP));
		}
		//
		for(int i = 1; i<=N; i++){
			int tempMax = dp[i-1];
			for(Iterator<Counseling> itr = cc[i].iterator(); itr.hasNext();){
				Counseling c = itr.next();
				int tempSum = dp[i - c.T] + c.P;
				if(tempMax < tempSum)
					tempMax = tempSum;
			}
			dp[i] = tempMax;
		}
		System.out.println(dp[N]);
	}
}

class Counseling{
	int T, P;
	Counseling(int T, int P){
		this.T = T;	this.P = P;
	}
	
	@Override
	public String toString(){
		return "T: "+T+", P: "+P;
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[] ary = null;
	static int[] sumAry = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		ary = new int[N+1];
		sumAry = new int[N+1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++){
			ary[i] = Integer.parseInt(st.nextToken());
			sumAry[i] = sumAry[i-1] + ary[i];	
		}
		// END OF INIT
		
		int count = 0;
		for(int i = 1; i<=N; i++){
			for(int j = N; i<=j; j--){
				if(sumAry[j] - sumAry[i-1] == M){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
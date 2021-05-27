import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());	int M = Integer.parseInt(st.nextToken());
		int[] ary = new int[N+1];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
			
		// END OF INIT
		
		int count = 0;
		int tempSum = 0;
		int i = 1;
		int j = i;
		while(i<=N){
			for( ; j<=N && tempSum < M; j++){
				tempSum += ary[j];
			}
			if(tempSum == M)
				count++;
			tempSum -= ary[i++];
		}
		System.out.println(count);
	}
}

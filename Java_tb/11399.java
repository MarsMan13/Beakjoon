import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] ary = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		long totTime = 0;
		long before = 0;
		for(int i = 0; i<N; i++){
			before += ary[i];
			totTime += before;
		}
		System.out.println(totTime);
	}
}
import java.util.*;
import java.io.*;

class Main{

	static final long DIV = 1000000007L;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[][] ary = new long[N+1][2];
		ary[1][0] = 2L;
		if(N >= 2){
			ary[2][0] = 7L;
			ary[2][1] = 1L;
			for(int i = 3; i<=N; i++){
				ary[i][0] = (2 * ary[i-1][1] + 2 * ary[i-1][0] + 3 * ary[i-2][0]) % DIV;
				//
				ary[i][1] = (ary[i-2][0] + ary[i-1][1]) % DIV;
			}
		}
		System.out.println(ary[N][0]);
	}
}
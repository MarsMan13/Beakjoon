import java.util.*;
import java.io.*;

class Main{
	
	static int N, r, c;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		def((int)Math.pow(2, N), r, c, 0L);
	}

	public static void def(int n, int i, int j, long count){
		if(n == 1){
			System.out.println(count);
			return;
		}
		if(i < n/2 && j < n/2)
			def(n/2, i, j, count);
		if(i < n/2 && n/2 <= j)
			def(n/2, i, j-n/2, count + (n/2 * n/2));
		if(n/2 <= i && j < n/2)
			def(n/2, i-n/2, j, count + (n/2 * n/2) * 2);
		if(n/2 <= i && n/2 <= j)
			def(n/2, i-n/2, j-n/2, count + (n/2 * n/2) * 3);
	}
}
import java.util.*;
import java.io.*;



class Main{
	
	static int N, K;
	static int[][] stuffs = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		stuffs = new int[N][2];
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			stuffs[i][0] = w;
			stuffs[i][1] = v;
		}
	}
	
}


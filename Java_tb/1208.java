import java.util.*;
import java.io.*;


class Main{
	
	static int N, S;
	static int[] input = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	S = Integer.parseInt(st.nextToken());
		input = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
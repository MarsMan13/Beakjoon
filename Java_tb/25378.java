import java.util.*;
import java.io.*;

class Main{
	
	static int N;
	static int[] array;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		array = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			array[i] = Integer.parseInt(st.nextToken());
		}
		//
	}
}
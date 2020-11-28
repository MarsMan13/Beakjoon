import java.util.*;
import java.io.*;

class Main{

	static int n;
	static int[] ary;

	public static void main(String[] args) throws IOException {

	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		ary = new int[n+1];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<n; i++){
			ary[i] = Integer.parseInt(st.nextToken());
		}

		// END OF INIT
	
		

	}

	static int go(){

		Arrays.sort(ary);
			
	}
}

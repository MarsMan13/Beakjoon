import java.util.*;
import java.io.*;



class Main{

	static int[] pp;
	static int[] diff;
	static int n;
	static int k;

	public static void main(String[] args) throws IOException{


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		pp = new int[n+1];
		diff = new int[n+1];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<n; i++){
			pp[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<n; i++){
			diff[i] = pp[i] - pp[i-1];
		}

		// END OF INIT

		
		long result = pp[n-1] - pp[0];

		Arrays.sort(diff);
		for(int i = n; n-k+1<i; i--){
			result -= diff[i];	
		}

		System.out.println(result);
	

	}


}

import java.util.*;
import java.io.*;


class Main{

	static int[] input = new int[1];	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer();
			input = new int[N+1];
			for(int i = 1; i<=N; i++)	input[i] = Integer.parseInt(st.nextToken());
			//
			
		}
	}
	
	public static int def(int left, int right){
		if(left == right)
			return input[left];
		
		int mid = (left + right) / 2;
		int ret1 = 0;	int ret2 = 0;	int ret3 = 0;
		if(left <= mid)
			ret1 = def(left, mid);
		if(mid+1 <= right)
			ret2 = def(mid+1, right);
		//
		for(int i = mid; left<=i; i--){
			
		}
	}
}
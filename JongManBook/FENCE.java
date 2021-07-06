import java.util.*;
import java.io.*;


class Main{
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int[] input = new int[N];
			result = 0;
			for(int i = 0; i<N; i++){
				input[i] = Integer.parseInt(st.nextToken());
			}
			//
			def(input, 0, N-1);
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int[] input, int start, int end){
		if(start == end){
			result = Math.max(input[start], result);
			return input[start];
		}
		// else
		int mid = (start + end) / 2;
		int leftHeight = Integer.MAX_VALUE;
		if(start <= mid){
			leftHeight = def(input, start, mid);
		}
		int rightHeight = Integer.MAX_VALUE;
		if(mid+1 <= end){
			rightHeight = def(input, mid+1, end);
		}
		int minHeight = Math.min(leftHeight, rightHeight);
		int tinyResult = minHeight * (end - start + 1);
		result = Math.max(tinyResult, result);
		return minHeight;
	}
}
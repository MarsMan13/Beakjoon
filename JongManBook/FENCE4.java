import java.util.*;
import java.io.*;


class Main{

	static int[] input = new int[1];	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			input = new int[N+2];
			for(int i = 1; i<=N; i++)	input[i] = Integer.parseInt(st.nextToken());
			//
			sb.append(def(1, N));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	
	}
	
	public static int def(int left, int right){
		if(left == right)
			return input[left];
		
		int mid = (left + right) / 2;
		int ret = Math.max(def(left, mid), def(mid+1, right));
		//
		int tempH = input[mid];
		int leftIndex = mid;	int rightIndex = mid;
		while(left < leftIndex || rightIndex < right){
			if(rightIndex < right && (leftIndex == left || input[leftIndex-1] < input[rightIndex+1])){
				rightIndex++;
			}
			else{
				leftIndex--;
			}
			tempH = Math.min(tempH, Math.min(input[leftIndex], input[rightIndex]));
			ret = Math.max(ret, tempH * (rightIndex - leftIndex + 1));
		}
		return ret;
		
	}
}
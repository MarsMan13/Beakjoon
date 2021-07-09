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
			input = new int[N+1];
			for(int i = 1; i<=N; i++)	input[i] = Integer.parseInt(st.nextToken());
			//
			sb.append(def(1, N));	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int left, int right){
		if(left == right)
			return input[left];
		
		int ret = 0;
		int mid = (left + right) / 2;
		if(left <= mid){
			int temp = def(left, mid);
			if(ret < temp)
				ret = temp;
		}
		if(mid+1 <= right){
			int temp = def(mid+1, right);
			if(ret < temp)
				ret = temp;
		}
		//
		int leftIndex = mid;	int rightIndex = mid;
		int tempH = input[mid];
		while(true){
			tempH = Math.min(tempH, Math.min(input[leftIndex], input[rightIndex]));
			int tempW = rightIndex - leftIndex + 1;
			int tempS = tempH * tempW;
			if(ret < tempS)	ret = tempS;
			if(leftIndex == left && rightIndex == right)	break;
			//
			if(leftIndex == left)			rightIndex++;
			else if(rightIndex == right)	leftIndex--;
			else{
				int nextLeftIndex = leftIndex-1;
				int nextRightIndex = rightIndex+1;
				// CASE 1
				if(tempH <= input[nextLeftIndex] && tempH <= input[nextRightIndex]){
					leftIndex--;	rightIndex++;
				}	// CASE 2
				else{
					if(input[nextLeftIndex] < input[nextRightIndex])	rightIndex++;
					else												leftIndex--;
				}
			}
		}
		return ret;
		
	}
}
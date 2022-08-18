import java.util.*;
import java.io.*;

class Main{

	static int[] inputs = null;
	static long[] tree = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int length = Integer.parseInt(st.nextToken());
			inputs = new int[length];
			if(length == 0)	break;
			for(int i = 0; st.hasMoreTokens(); i++){
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			// END OF INIT
			sb.append(def(0, length-1));
			sb.append("\n");
		}	
		System.out.print(sb.toString());
	}

	public static long def(int start, int end){
		if(start == end) return inputs[start];
		//
		int mid = (start + end) / 2;
		long leftMax = def(start, mid);
		long rightMax = def(mid+1, end);

		long midMax = inputs[mid];
		int midHeight = inputs[mid];
		int left = mid-1;
		int right = mid+1;
		while(start <= left && right <= end){
			if(inputs[left-1] >= inputs[right+1]){
				midHeight = Math.min(inputs[left], midHeight);
				midMax = Math.max(midMax, midHeight * (right - left - 1)); 
				left--;
			}
			else {
				midHeight = Math.min(inputs[right], midHeight);
				midMax = Math.max(midMax, midHeight * (right - left - 1)); 
				right++;
			}
		}
		for(; start < left; left--){
			midHeight = Math.min(inputs[left], midHeight);
			midMax = Math.max(midMax, midHeight * (right - left + 1)); 
		}
		for(; right < end; right++){
			midHeight = Math.min(inputs[right], midHeight);
			midMax = Math.max(midMax, midHeight * (right - left + 1)); 
		}
		System.out.printf("start: %d, end: %d\n", start, end);
		System.out.printf("%d %d %d\n", leftMax, midMax, rightMax);
		return Math.max(midMax, Math.max(leftMax, rightMax));
	}

}
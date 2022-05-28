import java.util.*;
import java.io.*;


class Main{
	
	static int n;
	static int[] input = null;
	static int[] sum = null;
	static final int MAX = 100000 * 1000 * 10;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		input = new int[n+1];
		sum = new int[n+1];
		st = new StringTokenizer(bf.readLine());
		int tempSum = 0;
		for(int i = 1; i<=n; i++){
			input[i] = Integer.parseInt(st.nextToken());
			sum[i] = tempSum += input[i];
		}
		//
		int[] leftMins = new int[n+1];
		leftMins[1] = 0;
		int leftMin = sum[1];
		for(int i = 2; i<=n; i++){
			leftMins[i] = leftMin;
			if(sum[i] < leftMin)
				leftMin = sum[i];
		}
		//
		int rightMax = sum[n];
		int[] rightMaxs = new int[n+1];
		for(int i = n; 0<i; i--){
			if(rightMax < sum[i])
				rightMax = sum[i];
			rightMaxs[i] = rightMax;
		}
		//
		int result = MAX * -1;
		for(int i = 1; i<=n; i++){
			if(result < rightMaxs[i] - leftMins[i])
				result = rightMaxs[i] - leftMins[i];
		}
		System.out.println(result);
	}
}















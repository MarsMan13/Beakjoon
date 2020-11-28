import java.util.*;
import java.io.*;


class Main{

	static int N;
	static int S;
	static int[] ary = null;
	static int[] sumAry = null;
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		ary = new int[N+2];
		sumAry = new int[N+2];

		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=N; i++){
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		int tempSum = 0;
		for(int i = 1; i<=N; i++){
			tempSum += ary[i];
			sumAry[i] = tempSum;
		}
		// END OF INIT
		
		int ret = 0;
		for(int i = 1; i<=N; i++){
			int fromSum = sumAry[i];

			int rootIndex = i-1;
			int startIndex = i;
			int endIndex = N;

			int midIndex = -1;
			while(startIndex <= endIndex){
				midIndex = (startIndex + endIndex) / 2;
				
				if(S <= sumAry[midIndex] - sumAry[rootIndex]){
					if(midIndex - rootIndex < ret || ret == 0){
						ret = midIndex - rootIndex;
					}
					endIndex = midIndex - 1;
				}
				else{
					startIndex = midIndex + 1;
				}
			}
		}

		System.out.println(ret);

	}
}

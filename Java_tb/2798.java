import java.util.*;
import java.io.*;



class Main{
	
	static int N = 0, M = 0;
	static int[] inputs = null;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		inputs = new int[N];
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		// END OF INIT
		Arrays.sort(inputs);

		for(int i = N-1; 0<=i; i--){
			int iSum = inputs[i];
			for(int j = i-1; 0<=j; j--){
				iSum += inputs[j];
				for(int k = j-1; 0<=k; k--){
					iSum += inputs[k];
					if(iSum <= M && (result < iSum || result == -1)){
						result = iSum;
					}
					iSum -= inputs[k];
				}
				iSum -= inputs[j];
			}
		}
		System.out.println(result);
	}

}

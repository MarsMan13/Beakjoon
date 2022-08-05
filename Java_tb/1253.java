import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] inputs = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			inputs[i] = Integer.parseInt(st.nextToken());
		}	
		Arrays.sort(inputs);
		// END OF INIT
		int ret = 0;
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				if(i == j)	continue;
				int target = inputs[i] - inputs[j];
				int targetIndex = Arrays.binarySearch(inputs, target);
				if(targetIndex < 0)	continue;
				boolean flag = false;
				for(int k = targetIndex ; 0<=k ; k--){
					if(target != inputs[k])	break;
					else if(k != i && k != j){
						flag = true;
						break;
					}
				}
				if(!flag){
					for(int k = targetIndex+1 ; k<N ; k++){
						if(target != inputs[k])	break;
						else if(k != i && k != j){
							flag = true;
							break;
						}
					}
				}
				if(flag){
					ret++;
					break;
				}
			}
		}
		System.out.println(ret);
	}
}
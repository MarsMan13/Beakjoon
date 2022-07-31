import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] plugs = new int[N];
		int[] items = new int[K];
		for(int i = 0; i<K; i++){
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		OUTER:
		for(int i = 0; i<K; i++){
			// CHECK ALREADY PLUGED
			// CHECK EMPTY PLUG
			for(int p = 0; p<N; p++){
				if(plugs[p] == 0 || plugs[p] == items[i]){
					plugs[p] = items[i];
					continue OUTER;
				}
			}
			// 
			// NEED TO REMOVE 
			int targetPlug = 0;
			int[] plugsIndex = new int[N];
			for(int p = 0; p < N; p++){
				plugsIndex[p] = 1000;
				for(int j = i; j < K; j++){
					if(plugs[p] == items[j]){
						plugsIndex[p] = j;
						break;
					}
				}
				// END OF PROC
				if(plugsIndex[targetPlug] < plugsIndex[p])
					targetPlug = p;
			}
			//
			plugs[targetPlug] = items[i];
			count++;
		}
		System.out.println(count);
	}
}
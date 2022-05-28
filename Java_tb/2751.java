import java.util.*;
import java.io.*;


class Main{
	
	static int N = 0;
	static int[] inputs = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		inputs = new int[N+1];
		for(int i = 1; i<=N; i++){
			inputs[i] = Integer.parseInt(bf.readLine());
		}
		
		// END OF INIT
		mergeSort(1, N);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++){
			sb.append(inputs[i]);
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
			
	}
	
	static void mergeSort(int left, int right){
	
		int mid = 0;
		if(left < right){
			mid = (left + right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right){
		int[] tempArray = new int[right-left+1];
		int p1 = left;
		int p2 = mid+1;
		int tempPointer = 0;
		while((p1 <= mid) && (p2 <= right)){
			if(inputs[p1] < inputs[p2]){
				tempArray[tempPointer++] = inputs[p1++];	
			}
			else{
				tempArray[tempPointer++] = inputs[p2++];
			}
		}
		while((p1 <= mid)){
			tempArray[tempPointer++] = inputs[p1++];
		}
		while((p2 <= right)){
			tempArray[tempPointer++] = inputs[p2++];
		}
		
		for(int i = 0; i<right-left+1; i++){
			inputs[i+left] = tempArray[i];
		}
	}
}
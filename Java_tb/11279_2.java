import java.util.*;
import java.io.*;



class Main{
	
	static int[] heap = new int[100001];
	static int size = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int step = 0; step<N; step++){
			int input = Integer.parseInt(bf.readLine());
			if(input == 0){
				sb.append(get());
				sb.append("\n");
			}
			else{
				insert(input);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int get(){
		if(size == 0){
			return 0;
		}
		int ret = heap[1];
		int index = 1;
		heap[index] = heap[size--];
		int leftChild = index * 2;
		while(leftChild <= size && (heap[index] < heap[leftChild] || heap[index] < heap[leftChild + 1])){
			int next = leftChild;
			if(leftChild + 1 <= size){
				if(heap[leftChild + 1] > heap[leftChild])
					next = leftChild + 1;
			}
			int temp = heap[index];
			heap[index] = heap[next];
			heap[next] = temp;
			index = next;
			leftChild = index * 2;
		}
		return ret;
	}
	
	public static void insert(int value){
		heap[++size] = value;
		int index = size;
		int parent = size / 2;
		while(1 <= parent && heap[index] > heap[parent]){
			int temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
			index = parent;
			parent = index/2;
		}
	}
}


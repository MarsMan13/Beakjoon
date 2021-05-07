import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PQ pq = new PQ(N);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++){
			int input = Integer.parseInt(bf.readLine());
			if(input == 0){
				sb.append(pq.delete());
				sb.append("\n");
			}
			else{
				pq.put(input);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}

class PQ{
	
	int size = 0;
	int[] heap = null;
	
	PQ(int n){
		this.heap = new int[2*n+1];
	}

	public void put(int value){
		heap[++size] = value;
		int index = size;
		int parent = index /2;
		while(1<=parent && heap[parent] < heap[index]){
			int temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp;
			index = parent;
			parent = index /2;
		}
	}
	
	public int delete(){
		if(size == 0)
			return 0;
		int ret = heap[1];
		int index = 1;
		heap[index] = heap[size--];
		int leftChild = index * 2;
		while(leftChild <= size){
			int next = leftChild;
			int rightChild = leftChild+1;
			if(rightChild <= size && heap[leftChild] < heap[rightChild])
				next = rightChild;
			if(heap[index] < heap[next]){
				int temp = heap[index];
				heap[index] = heap[next];
				heap[next] = temp;
				index = next;
				leftChild = index * 2;
			}
			else
				break;
		}
		return ret;
	}
	
}
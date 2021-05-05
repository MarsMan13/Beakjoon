import java.util.*;
import java.io.*;


class Main{
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int numCom = Integer.parseInt(st.nextToken());
		
			DualPriorityQueue queue = new DualPriorityQueue(1000000);
			for(int c = 0; c < numCom; c++){
				st = new StringTokenizer(bf.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")){
					queue.insert(value);
				}
				else if(command.equals("D")){
					queue.delete(value);
				}
			}
			if(queue.size < 1){
				sb.append("EMPTY");
				sb.append("\n");
			}
			else{
				sb.append(queue.heap_straight[1].n);
				sb.append(" ");
				sb.append(queue.heap_reverse[1].n);
				sb.append("\n");
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}

class DualPriorityQueue{

	int size = 0;
	Dipole[] heap_straight = null;	//bigest,	comparator == -1
	Dipole[] heap_reverse = null;	//smallest, comparator == 1
	
	DualPriorityQueue(int n){
		this.heap_straight = new Dipole[n+1];
		this.heap_reverse = new Dipole[n+1];
	}

	public void delete(int d){

		if(size == 0)
			return;
		
		Dipole[] heap = heap_reverse;
		if(d == 1)
			heap = heap_straight;
		Dipole target = heap[1];
		heap[1].n = heap[size--].n;
		heapify(heap, d, 1);
		
		target = target.friend;
		
		heap = heap_straight;
		if(d == 1)
			heap = heap_reverse;
		heap[target.index].n = heap[size+1].n;
		heapify(heap, d * -1, target.index);
	}
	
	public void heapify(Dipole[] heap, int comparator, int index){
		int leftChild = index * 2;
		while(leftChild <= size && 
			  (heap[index].n*comparator < heap[leftChild].n*comparator || 
			   heap[index].n*comparator < heap[leftChild + 1].n*comparator)){
			int next = leftChild;
			if(leftChild + 1 <= size){
				if(heap[leftChild + 1].n*comparator > heap[leftChild].n*comparator)
					next = leftChild + 1;
			}
			{
				Dipole temp = heap[index];
				heap[index] = heap[next];
				heap[next] = temp;
			}
			{
				int temp = heap[index].index;
				heap[index].index = heap[next].index;
				heap[next].index = temp;
			}
			
			index = next;
			leftChild = index * 2;
		}
	}
	

	public void insert(int value){
		size++;
		Dipole dipole1 = new Dipole(value, size);
		Dipole dipole2 = new Dipole(value, size);
		Dipole.makeDipole(dipole1, dipole2);
		heap_straight[size] = dipole1;
		heap_reverse[size] = dipole2;
		
		for(int comparator = -1; comparator<=1; comparator+=2){
			Dipole[] heap = heap_straight;
			if(comparator == -1)
				heap = heap_reverse;
			int index = size;
			int parent = size / 2;
			while(1 <= parent && heap[index].n*comparator > heap[parent].n*comparator){
				{
					Dipole temp = heap[index];
					heap[index] = heap[parent];
					heap[parent] = temp;
				}
				{
					int temp = heap[index].index;
					heap[index].index = heap[parent].index;
					heap[parent].index = temp;
				}
				index = parent;
				parent = index/2;
			}	
		}
		
	}
	
	
}

class Dipole{
	
	int n = 0;
	int index = 0;
	Dipole friend = null;
	
	Dipole(int n){
		this.n = n;
	}
	
	Dipole(int n, int index){
		this.n = n;
		this.index = index;
	}
	
	public static void makeDipole(Dipole d1, Dipole d2){
		d1.friend = d2;
		d2.friend = d1;
	}
	
}




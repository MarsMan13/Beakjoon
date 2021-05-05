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
			
			PriorityQueue<Integer> queueForBig = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> queueForSml = new PriorityQueue<>();
			
			for(int c = 0; c < numCom; c++){
				st = new StringTokenizer(bf.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")){
					queueForBig.offer(value);
					queueForSml.offer(value);
				}
				else if(command.equals("D")){
					if(value == 1){
						queueForBig.poll();
					}
					else if(value == -1){
						queueForSml.poll();
					}
				}
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
		
		int comparator = 1;
		int[] heap = heap_straight;
		if(d == -1){
			heap = heap_reverse;
			comparator = -1;
		}
		Dipole target = heap[1];
		heap[1] = heap[size--];
		heap[1].index = 1;
		heapify(heap, d, 1);
		
		target = target.friend;
		
		
		
		return ret;
	}
	
	public void heapify(int[] heap, int comparator, int index){
		int leftChild = index * 2;
		while(leftChild <= size && 
			  (heap[index]*comparator > heap[leftChild]*comparator || 
			   heap[index]*comparator > heap[leftChild + 1]*comparator)){
			int next = leftChild;
			if(leftChild + 1 <= size){
				if(heap[leftChild + 1]*comparator < heap[leftChild]*comparator)
					next = leftChild + 1;
			}
			{
				int temp = heap[index].index;
				heap[index].index = heap[next].index;
				heap[next].index = temp;
			}
			{
				int temp = heap[index];
				heap[index] = heap[next];
				heap[next] = temp;
			}	
			index = next;
			leftChild = index * 2;
		}
	}
	

	public void insert(int value){
		size++;
		Dipole dipole1 = new Dipole(value, size);
		Dipole dipole2 = new Dipole(valua, size);
		Dipole.makeDipole(dipole1, dipole2);
		heap_straight[size] = dipole1;
		heap_reverse[size] = dipole2;
		
		for(int comparator = -1; comparator<=1; comparator+=2){
			int[] heap = heap_straght;
			if(comparator == 1)
				heap = heap_reverse;
			int index = size;
			int parent = size / 2;
			while(1 <= parent && heap[index]*comparator < heap[parent]*comparator){
				int temp = heap[index];
				heap[index] = heap[parent];
				heap[parent] = temp;
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



















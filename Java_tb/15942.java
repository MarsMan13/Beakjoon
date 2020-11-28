import java.util.*;
import java.io.*;


class Main{

	static int N;
	static int k;
	static int p;
	static int end;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] heap;

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		k = sc.nextInt();
		p = sc.nextInt();

		heap = new int[N+1];
		for(int i = 1; i<=N; i++){
			pq.offer(i);
		}

		// END OF INIT
		if(canPut() == 1){
			System.out.println(-1);
			return;
		}



	}

	static int canPut(){
		
		int tempP = p;
		int level = 1;
		int min = p;
		int max = p;
		
		while(1 < tempP){
			tempP /=2;
			level++;
		}

		if(k<level){
			return 1;
		}

		while(!((N < min * 2) && (N < max * 2 + 1))){
			min = min * 2;
			max = max * 2 + 1;
		}

		int need = 0;
		end = (max < N) ? max : N;
		need += (end - min + 1);
		min /=2;
		max /=2;
		int gap = max - min;
		while(1 <= gap){
			need += gap + 1;
			min /= 2;
			max /= 2;
			gap = max - min;
		}

		if((N-k) < need){
			return 1;
		}
		System.out.println("need: "+need);

		return 0;
	}
}

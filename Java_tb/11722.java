import java.util.Scanner;
import java.util.Arrays;

class Main{

	static int N;
	static int[] data;
	static int[] dist;
	static int[] next;

	public static void main(String[] args){


		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		data = new int[N+1];
		dist = new int[N+1];
		next = new int[N+1];
		Arrays.fill(next, -1);

		for(int i = 0; i<N; i++){
			data[i] = sc.nextInt();
		}

		for(int i = N-1; 0<=i; i--){
			dp(i);
		}

		int maxIndex = 0;
		for(int i = 0; i<N; i++){
			if(dist[maxIndex] < dist[i]){
				maxIndex = i;
			}
		}
		System.out.println(dist[maxIndex]);
		while(true){
			System.out.print(data[maxIndex]+" ");
			if(maxIndex == next[maxIndex]) break;
			maxIndex = next[maxIndex];
		}
	}

	static void dp(int index){
		
		int maxIndex = index;
		for(int i = index+1; i<N; i++){
		
			if(data[index] < data[i] && dist[maxIndex] <= dist[i]){
				maxIndex = i;
			}
		}
		dist[index] = dist[maxIndex]+1;
		next[index] = maxIndex;
	}
}


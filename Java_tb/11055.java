import java.util.Scanner;


class Main{

	static int N;
	static int[] data;
	static int[] fromSum;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		data = new int[N+1];
		fromSum = new int[N+1];

		for(int i = 0; i<N; i++){
			data[i] = sc.nextInt();
			fromSum[i] = data[i];
		}

		for(int i = N-1; 0<= i; i--){
			dp(i);
		}

		int maxIndex = 0;
		for(int i = 0; i<N; i++){
			if(fromSum[maxIndex] < fromSum[i]){
				maxIndex = i;
			}
		}
		System.out.println(fromSum[maxIndex]);

	}

	static void dp(int index){
		
		int maxIndex = index;

		for(int i = index+1; i<N; i++){
			if(data[index] < data[i] && fromSum[maxIndex] < fromSum[i]){
				maxIndex = i;
			}
		}
	
		if(maxIndex != index)
			fromSum[index] += fromSum[maxIndex];

	}
}

import java.util.*;


class Main{

	static int N;
	static int S;
	static int count = 0;
	static int[] ary;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		ary = new int[N];

		for(int i = 0; i<N; i++){
			ary[i] = sc.nextInt();
		}
	
		S = sc.nextInt();
		
		// END OF INIT

		for(int i = 0; i<N; i++){
			int maxIndex = i;
			for(int j = i; j<=i+(S-count) && j<N; j++){
				if(ary[maxIndex] < ary[j]){
					maxIndex = j;
				}	
			}
			exchange(i, maxIndex);
		}

		for(int i = 0; i<N; i++){
			System.out.print(ary[i]);
			System.out.print(" ");
		}
		System.out.println();
	
		
	}

	static int exchange(int start, int end){	// a < b
		int temp = ary[end];
		for(int i = end; start<i; i--){
			ary[i] = ary[i-1];
			count++;
		}
		ary[start] = temp;
		return 0;
	}

}

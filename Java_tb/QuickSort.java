import java.util.Scanner;


public class QuickSort{

	static int size;
	static int[] data;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		size = sc.nextInt();
		data = new int[size+1];

		for(int i = 0; i<size; i++){
			data[i] = sc.nextInt();
		}

		// END OF INIT
		
		def1(0, size-1);
		
		for(int i = 0; i<size; i++){
			System.out.print(data[i] + " ");
		}
		
	}

	static void def1(int start, int end){
		int pivot = (start + end)/2;
		int left = start;
		int right = end;
		int temp;
	
		while(left <= right){
			while(data[left] < data[pivot])
				left++;

			while(data[right] > data[pivot])
				right--;
			
			if(left <= right){
				temp = data[right];
				data[right] = data[left];
				data[left] = temp;
				left++;
				right--;
			}
		}

		if(start < left-1){
			def1(start, left-1);
		}
		if(left < end){
			def1(left, end);
		}
	}
}

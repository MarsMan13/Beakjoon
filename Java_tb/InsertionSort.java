import java.util.Scanner;



public class InsertionSort{

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
		
		int temp;	
		for(int i = 1; i<size; i++){
			for(int j = i-1; 0<=j; j--){
				if(data[j] <= data[j+1]) break;
				else{	// data[j] > data[i]
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}

		for(int i = 0; i<size; i++){
			System.out.println(data[i]);
		}

		
	}
}

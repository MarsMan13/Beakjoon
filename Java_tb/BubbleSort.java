import java.util.Scanner;



public class BubbleSort{

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
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size-i-1; j++){
				if(data[j] > data[j+1]){
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

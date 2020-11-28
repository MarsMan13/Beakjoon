import java.util.Scanner;



public class SelectionSort{

	static int size;
	static int[] data;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		size = sc.nextInt();
		data = new int[size+1];

		for(int i = 0; i<size; i++){
			data[i] = sc.nextInt();
		}

		//END OF INIT
		
		
		int min;
		int temp;
		for(int i = 0; i<size; i++){
			min = i;
			for(int j = i; j<size; j++){
				if(data[j] < data[min]){
					min = j;
				}
			}
			temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}

		for(int i = 0; i<size; i++){
			System.out.print(data[i] + " ");
		}
	}
}

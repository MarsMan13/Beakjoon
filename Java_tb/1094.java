import java.util.*;


class Main{

	static int sticks;
	static int[] stickNum = new int[7];
	static int X;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		X = sc.nextInt();
		sticks = (1 << 6);	
		// INIT
	
		divide(0);
		
		System.out.println(countSticks());
		
		sc.close();
	}

	public static void divide(int mode){	
		// mode : 0 --> remove top, 1 --> dont remove top
		
		if(sumSticks() == X)
			return;
		
		int temp = sticks;
		int index = 0;
		while(temp != 0){
			if(temp % 2 == 1){
				break;
			}
			index++;
			temp = temp >> 1;
		}	
		sticks = sticks | (1 << (index-1));
		if(mode == 0){
			sticks = sticks & ~(1 << index);
		}
		//
		int sum = sumSticks();
		if(X <= sum)
			divide(0);
		else
			divide(1);
		
	}
	
	public static int countSticks(){
		int count = 0;
		while(sticks != 0){
			count += sticks % 2;
			sticks/=2;
		}
		return count;
	}
	
	public static int sumSticks(){
		int sum = 0;
		int value = 1;
		int temp = sticks;
		while(temp != 0){
			sum += value * (temp%2);
			temp /= 2;
			value *= 2;
		}
		return sum;
	}
}
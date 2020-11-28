import java.util.*;


class Main{


	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int count = 0;
/*
		int level = -1;
		for(int i = 1; i<=n ; i++){
			int temp = (n-1)/i;
			if(level == -1 || level != temp){
				if(i-1 != 0)
					System.out.println(" end at "+ (i-1));
				level = temp;
				System.out.println("level "+level+" starts at "+i);
			}
			count += ((n-1)/i) + 1;
		}
*/
		for(int k = 1; k<=n; k++){
			int left = (n-1)/(k+1);
			int right = (n-1)/k;
			count += (right - left) * (k+1);
		}

		System.out.println(count+1);

	}
}

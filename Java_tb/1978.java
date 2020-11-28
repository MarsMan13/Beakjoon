import java.util.Scanner;


class Main{

	static boolean[] primes;
	static int[] needTest;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int max = -1;
		needTest = new int[n];
		
		for(int i = 0; i<n; i++){
			needTest[i] = sc.nextInt();	
			if(needTest[i] > max)	
				max = needTest[i];
		}
		
		primes  = new boolean[max+1];

		for(int i = 2; i<= max; i++){
			if(primes[i]) continue;
			for(int j = i+i; j <= max; j += i){
				primes[j] = true;
			}
		}

		int count = 0;

		primes[1] = true;
		for(int i = 0; i<n; i++){
			if(!primes[needTest[i]]) count++;
		}

		System.out.println(count);
	}
}


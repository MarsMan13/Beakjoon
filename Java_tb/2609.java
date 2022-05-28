import java.util.*;
import java.io.*;



class Main{
	
	static List<Integer> primes = new LinkedList<>();
	static int lim = 10000;
	
	public static void main(String[] args){

		{
			int[] numbers = new int[lim+1];
			for(int i = 2; i<=lim; i++){
				if(numbers[i] == 0){
					primes.add(i);
					int index = 2 * i;
					while(index <= lim){
						numbers[index] = 1;
						index += i;
					}
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); int b = sc.nextInt();
	
		int[] as = new int[lim+1]; as[1] = 1;
		int[] bs = new int[lim+1]; bs[1] = 1;
		
		outer: 
		for(int p : primes){
			while(a%p == 0){
				a/=p;
				as[p]++;
				if(a == 1)
					break outer;
			}
		}
		outer2: 
		for(int p : primes){
			while(b%p == 0){
				b/=p;
				bs[p]++;
				if(b == 1)
					break outer2;
			}
		}
		
		int GCF = 1;
		int LCM = 1;
		for(int i = 1; i<=lim; i++){
			if(as[i] != 0 && bs[i] != 0){
				if(as[i] < bs[i])
					GCF *= Math.pow(i, as[i]);
				else
					GCF *= Math.pow(i, bs[i]);
			}
			if(as[i] != 0|| bs[i] != 0){
				if(as[i] < bs[i])
					LCM *= Math.pow(i, bs[i]);
				else
					LCM *= Math.pow(i, as[i]);
			}
		}
		
		System.out.println(GCF);
		System.out.println(LCM);
		
	}
}




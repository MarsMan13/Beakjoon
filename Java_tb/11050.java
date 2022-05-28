import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 
		
		System.out.println(factorial(N)/(factorial(K) * factorial(N-K)));
	}
	
	public static int factorial(int n){
		if(n == 1 || n == 0){
			return 1;
		}
		return n * factorial(n-1);
	}
}
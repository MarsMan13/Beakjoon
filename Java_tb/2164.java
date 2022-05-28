import java.util.*;
import java.io.*;



class Main{
	
	static int[] array = null;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		array = new int[2*N];
		for(int i = 1; i<=N; i++){
			array[i-1] = i;
		}
		int start = 0;
		int end = N-1;
		int size = N+1;
		
		while(--size != 1){
			start++;
			array[++end] = array[start++];
		}
		System.out.println(array[start]);
		
	}
}

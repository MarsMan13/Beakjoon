import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int aa = a;
		int bb = b;
		if(a < b){
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(b != 0){
			int temp = b;
			b = a % b;
			a = temp;
		}
		System.out.println(a);	
		System.out.println(aa * bb / a);
	}
}
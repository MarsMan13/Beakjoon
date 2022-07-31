import java.util.*;
import java.io.*;


class Main{

	static char[] S = new char[1001];
	static char[] T = new char[1001];
	static int lengthS = 0;
	static int lengthT = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		{
			char[] tempS = bf.readLine().toCharArray();
			for(int i = 0; i<tempS.length; i++)
				S[i] = tempS[i];
			lengthS = tempS.length;
		}
		{
			char[] tempT = bf.readLine().toCharArray();
			for(int i = 0; i<tempT.length; i++)
				T[i] = tempT[i];
			lengthT = tempT.length;
		}
		for(int i = lengthT - 1; lengthS <= i; i--){
			if(T[i] == 'B'){
				flip(i);
			}
		}
		//
		for(int i = 0; i<lengthS; i++){
			if(S[i] != T[i]){
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}

	public static void flip(int length){ 
		for(int i = 0; i<length/2; i++){
			char temp = T[i];
			T[i] = T[length - i - 1];
			T[length - i - 1] = temp;
		}
	}
}
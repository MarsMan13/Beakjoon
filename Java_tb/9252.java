import java.util.*;
import java.io.*;


class Main{
	
	static String str1, str2;
	static int[] ary1, ary2;
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		str1 = bf.readLine();
		str2 = bf.readLine();
		ary1 = new int[str1.length() + 1];
		ary2 = new int[str2.length() + 1];
	
		int strLength1 = str1.length();
		int strLength2 = str2.length();
		
		int end = strLength1 < strLength2 ? strLength2 : strLength1;
		
		for(int i = 2; i<=end; i++){
			int upperMax = 0;
			int lowerMax = 0;
			for(int j = i; 0<=j; j--){
				if(i<=strLength1){
					if(str1.chatAt(i) == str2.chatAt(j)){
						
					}
				}
				if(i<=strLength2){
					if(str2.chatAt(i) == str1.chatAt(j)){
						
					}
				}
			}
		}
		
	}
}
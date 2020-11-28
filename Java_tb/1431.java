import java.util.Scanner;
import java.util.Arrays;


class Main{

	static Serial[] list;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		list = new Serial[n];

		for(int i = 0; i<n; i++){
			String temp = sc.nextLine();
			list[i] = new Serial(temp);
		}

		Arrays.sort(list);

		for(int i = 0; i<n; i++){
			System.out.println(list[i].serial);
		}

	}
}


class Serial implements Comparable<Serial>{

	String serial;

	Serial(String srl){
		this.serial = srl;
	}

	@Override
	public int compareTo(Serial s){
		// Condition 1
		if(this.serial.length() != s.serial.length())
			return this.serial.length() - s.serial.length();
		
		// Condition 2
		int count1 = 0;
		int count2 = 0;

		for(int i = 0; i<this.serial.length(); i++){
			char c = this.serial.charAt(i);
			if(Character.isDigit(c)){
				count1 += (int)(c - '0');
			}
		}
		for(int i = 0; i<s.serial.length(); i++){
			char c = s.serial.charAt(i);
			if(Character.isDigit(c)){
				count2 += (int)(c - '0');
			}
		}
		if(count1 != count2)	
			return count1 - count2;

		// Condition 3
		return this.serial.compareTo(s.serial);

	}
}

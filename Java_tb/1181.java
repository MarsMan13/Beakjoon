import java.util.Scanner;
import java.util.Arrays;


class Main{

	static SortableString[] list;
	

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		
		list = new SortableString[n];

		for(int i = 0; i<n; i++){
			String temp = sc.nextLine();

			list[i] = new SortableString(temp);
		}

		//END OF INIT

		Arrays.sort(list);

		for(int i = 0; i<n; i++){
			if(i > 0 && list[i-1].str.equals(list[i].str)) continue;
			System.out.println(list[i]);
		}
		

	}

}


class SortableString implements Comparable<SortableString>{

	String str;

	SortableString(String str){
		this.str = str;
	}

	@Override
	public int compareTo(SortableString a){
		if(this.str.length() > a.str.length())
			return 1;
		else if(this.str.length() < a.str.length())
			return -1;
		return (this.str.compareTo(a.str));
	}

	@Override
	public String toString(){
		return this.str;
	}
	
}

import java.util.*;


class Main{


	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt() - sc.nextInt();

		if(a < 0){
			System.out.println("<");
		}
		else if(0 < a){
			System.out.println(">");
		}
		else{
			System.out.println("==");
		}
	}
}

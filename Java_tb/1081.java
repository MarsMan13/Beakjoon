import java.util.*;


class Main{

	static int from = 0;
	static int[] fromNums;
	static int to = 0;
	static int[] toNums;

	static int fromLength = 0;
	static int toLength = 0;

	static long[] full;
	static long[] until = {0L, 1L, 3L, 6L, 10L, 15L, 21L, 28L, 36L, 45L, 45L};

	static long ret = 0;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		from = sc.nextInt()-1;
		String tempFrom = Integer.toString(from);
		fromNums = new int[tempFrom.length()];
		for(int i = 0; i < tempFrom.length(); i++){
			fromNums[i] = tempFrom.charAt(i) - '0';
		}
		to = sc.nextInt();
		String tempTo = Integer.toString(to);
		toNums = new int[tempTo.length()];
		for(int i = 0; i < tempTo.length(); i++){
			toNums[i] = tempTo.charAt(i) - '0';
		}
		
		fromLength = tempFrom.length();
		toLength = tempTo.length();
		
		// END OF INIT
	
		/* 
		 * i
		 * 70...000
		 * ret += ( 7 * full[i-1] + until[7] )
		 *
		 ***************************************
		 *
		 * i
		 * 10...000
		 * full[i] = ( 1 * full[i-1])
		 *
		 */

		full = new long[length+1];
		full[0] = 45L;
		for(int i = 1; i<=length; i++){
			full[i] = (full[i-1] * 10) + until[10];	
		}
		// END OF MAKING FULL ARRAY


		for(int i = from; i<=to; i++){
					
		}

		/*
		for(int i = 0; i<fromNums.length; i++){
			if(i == fromNums.length-1){
				ret -= until[fromNums[i]];
			}
			else{
				ret -= (fromNums[i] * full[i] + until[fromNums[i]]);
			}
		}
		*/

	}

}

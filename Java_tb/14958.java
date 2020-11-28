import java.util.*;
import java.io.*;


class Main{

	static char[] data1;
	static char[] data2;
	static int[] result;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		result = new int[n+m+1];
		dp = new int[n+m+1];


		data1 = bf.readLine().toCharArray();
		data2 = bf.readLine().toCharArray();

		// END OF INIT
		//

		int maxCount = 0;
		int tempCount = 0;
		for(int i = 0; i<=n-1; i++){
			tempCount = 0;
			for(int j = 0; j<m; j++){
				if(n <= i+j)	continue;
				if(isWin(data2[j], data1[i+j])){
					tempCount++;
				}	
			}
			if(maxCount < tempCount){
				maxCount = tempCount;
			}
		}

		System.out.println(maxCount);
		
	}

	static boolean isWin(char me, char that){
		if(me == 'R'){
			if(that == 'S')
				return true;
		}
		else if(me == 'S'){
			if(that == 'P')
				return true;
		}
		else if(me == 'P'){
			if(that == 'R')
				return true;
		}
		return false;
	}

}

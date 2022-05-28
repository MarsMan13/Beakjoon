import java.util.*;
import java.io.*;

/*

	HINT :
	Fi+1 = 1 1^i * F1
	Fi     0 0     F0

*/


class Main{
	
	static int n = 0;
	static final int div = 1000000007;
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
	
		long[][] ret = matNmul(n-1);
		System.out.println(ret[0][0]);
		
		sc.close();
	}
	
	static long[][] basicMat = new long[][]{{1, 1}, {1, 0}};
	
	public static long[][] matNmul(long n){
		if(n == 1 || n == 0)
			return basicMat;
		long[][] temp = null;
		long[][] temp2 = basicMat;
		long[][] ret = new long[2][2];
		if(n % 2 == 1){
			temp = matNmul(n-1);
		}
		else{
			temp = matNmul(n/2);
			temp2 = temp;
		}
		ret[0][0] = (temp[0][0] * temp2[0][0] % div + temp[0][1] * temp2[1][0] % div)%div;
		ret[0][1] = (temp[0][0] * temp2[0][1] % div + temp[0][1] * temp2[1][1] % div)%div;
		ret[1][0] = (temp[1][0] * temp2[0][0] % div + temp[1][1] * temp2[1][0] % div)%div;
		ret[1][1] = (temp[1][0] * temp2[0][1] % div + temp[1][1] * temp2[1][1] % div)%div;
		return ret;
	}
}





import java.util.*;
import java.io.*;
/*
 * 1과 2로 쫌갰습니다
 * 		2 4 --> YES
 * 1	0 0 tot 0  y = 0
 * 2 	1 2 tot 3  x = 3
 * 
 * x : 2의 갯수
 * y : 1의 갯수
 * x == y
 * 
 * x - 1k = y + 2k
 * x - y = 3k (k >= 0)
 * (x - y)%3 == 0 ?
 */

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int about1 = 0;
		int about2 = 0;
		for(int i = 0; i<N; i++){
			int temp = Integer.parseInt(st.nextToken());
			about2 += temp / 2;
			about1 += temp % 2;
		}
		if((about2 - about1) >= 0 && (about2 - about1) % 3 == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
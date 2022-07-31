import java.util.*;
import java.io.*;

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
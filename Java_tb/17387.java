import java.util.*;
import java.io.*;


class Main{


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// About Polong 1
		long x1 = Long.parseLong(st.nextToken());	long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());	long y2 = Long.parseLong(st.nextToken());
		// About Polong 2
		st = new StringTokenizer(bf.readLine());
		long x3 = Long.parseLong(st.nextToken());	long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());	long y4 = Long.parseLong(st.nextToken());
	
		long ret1 = (1L*(x2-x1)*y3-(1L*(y2-y1)*(x3-x1)+1L*y1*(x2-x1)));
		long ret2 = (1L*(x2-x1)*y4-(1L*(y2-y1)*(x4-x1)+1L*y1*(x2-x1)));
		long ret3 = (1L*(x4-x3)*y1-(1L*(y4-y3)*(x1-x3)+1L*y3*(x4-x3)));
		long ret4 = (1L*(x4-x3)*y2-(1L*(y4-y3)*(x2-x3)+1L*y3*(x4-x3)));
		
		if(ret1*ret2 <= 0 && ret3*ret4 <= 0){
			if(ret1 == 0 && ret2 == 0){
				if(((x3 < x1) && (x4 < x1) && (x3 < x2) && (x4 < x2)) || ((x3 > x1) && (x4 > x1) && (x3 > x2) && (x4 > x2)))
					System.out.println(0);
				else if(((y3 < y1) && (y4 < y1) && (y3 < y2) && (y4 < y2)) || ((y3 > y1) && (y4 > y1) && (y3 > y2) && (y4 > y2)))
					System.out.println(0);
				else
					System.out.println(1);
			}
			else
				System.out.println(1);
		}	
		else
			System.out.println(0);
		
	}
}
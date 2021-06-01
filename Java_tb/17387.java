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
	
		if(ret1*ret2 == 0 && ret3*ret4 == 0){
			// about x1, y1 : a / x2, y2 : b
			if(y2 < y1 || (y2 == y1 && x2 < x1)){
				{
					long temp = y2;	y2 = y1;	y1 = temp;
				}
				{
					long temp = x2;	x2 = x1;	x1 = temp;
				}
			}
			if(y4 < y3 || (y4 == y3 && x4 < x3)){
				{
					long temp = y4;	y4 = y3;	y3 = temp;
				}
				{
					long temp = x4;	x4 = x3;	x3 = temp;
				}
			}
			//
			if(((x1 == x3 && y1 == y3) || (x2 == x4 && y2 == y4)) || (x1 == x4 && y1 == y4) || (x2 == x3 && y2 == y3)){
				System.out.println(1);
			}
			else{
				int flag1 = 0;	int flag2 = 0;
				if(y1 < y4 || (y1 == y4 && x1 < x4))
					flag1 = 1;
				if(y2 < y3 || (y2 == y3 && x2 < x3))
					flag2 = 1;
				if(flag1 == flag2)
					System.out.println(0);
				else
					System.out.println(1);
			}	
			
		}
		else if(ret1*ret2 <= 0 && ret3*ret4 <= 0)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
}
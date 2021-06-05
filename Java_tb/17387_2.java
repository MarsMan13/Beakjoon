import java.util.*;
import java.io.*;


class Main{
	
	static Line line1, line2;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		line1 = new Line(new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())), 
						 new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		//
		st = new StringTokenizer(bf.readLine());
		line2 = new Line(new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())), 
						 new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		//
		int ret1 = line1.CCW(line2.p1);
		int ret2 = line1.CCW(line2.p2);
		int ret3 = line2.CCW(line1.p1);
		int ret4 = line2.CCW(line1.p2);
		
		if(ret1*ret2 == 0 && ret3*ret4 == 0){
			line1.sortOwnPair();
			line2.sortOwnPair();
	
			if(line1.p1.compareTo(line2.p2) <= 0 && line2.p1.compareTo(line1.p2) <= 0)
				System.out.println(1);
			else
				System.out.println(0);
		}
		else if(ret1 * ret2 <= 0 && ret3*ret4 <= 0)
			System.out.println(1);	
		else
			System.out.println(0);
	}
	
}

class Line{
	Pair p1, p2;
	Line(Pair p1, Pair p2){
		this.p1 = p1; this.p2 = p2;
	}
	
	public void sortOwnPair(){
		int flag = p1.compareTo(p2);
		if(flag == 1){
			Pair temp = p1;
			p1 = p2;
			p2 = temp;
		}
	}
	
	public int CCW(Pair p3){
		long ret = 1L*(p2.i - p1.i)*(p3.j - p1.j) - 1L*(p3.i - p1.i)*(p2.j - p1.j);

		if(ret > 0L)			//CCW
			return 1;
		else if(ret == 0L)	//paraller?
			return 0;
		return -1;			//CW
	}
}


class Pair implements Comparable<Pair>{
	long i, j;
	
	Pair(long i, long j){
		this.i = i;	this.j = j;
	}
	
	@Override
	public int compareTo(Pair p){
		if(this.i == p.i && this.j == p.j)
			return 0;
		if(this.j < p.j)
			return -1;
		if(this.j == p.j && this.i < p.i){
			return -1;
		}
		return 1;
		
	}
}
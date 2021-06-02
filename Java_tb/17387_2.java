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
		long ret1 = line1.CCW(line2.p1);
		long ret2 = line1.CCW(line2.p2);
		long ret3 = line2.CCW(line1.p1);
		long ret4 = line2.CCW(line1.p2);
		if(ret1*ret2 == 0 && ret3*ret4 == 0){
			line1.sortOwnPair();
			line2.sortOwnPair();
			int flag1 = line1.p1.positionCheck(line2.p2);
			int flag2 = line1.p2.positionCheck(line2.p1);
			if(line1.p1.equals(line2.p1) || line1.p2.equals(line2.p2)
			  || line1.p1.equals(line2.p2) || line1.p2.equals(line2.p1))
				System.out.println(1);
			else if(flag1 * flag2 < 0)
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
		int flag = 0;
		if(p2.j < p1.j)
			flag = 1;
		else if(p2.j == p1.j && p2.i < p1.i)
			flag = 1;
		
		if(flag == 1){
			Pair temp = p1;
			p1 = p2;
			p2 = temp;
		}
	}
	
	public long CCW(Pair p3){
		return (p3.i - p1.i)*(p2.j - p1.j) - (p2.i - p1.i)*(p3.j - p1.j);
	}
	
	@Override
	public String toString(){
		return "Point1: "+this.p1.toString() +" / " + "Point2: "+this.p2.toString();
	}
}


class Pair{
	long i, j;
	
	Pair(long i, long j){
		this.i = i;	this.j = j;
	}
	
	public int positionCheck(Pair p){
		if(p.i == this.i && p.j == this.j)
			return 0;
		if(p.j < this.j)
			return 1;
		if(p.j == this.j && p.i < this.i)
			return 1;
		return -1;
	}

	@Override
	public boolean equals(Object p){
		return this.i == ((Pair)p).i && this.j == ((Pair)p).j;
	}
	
	@Override
	public String toString(){
		return "i: "+this.i + ", " + this.j;
	}
}
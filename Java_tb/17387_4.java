
import java.util.*;


class Main{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Pair p1 = new Pair(sc.nextLong(), sc.nextLong());
		Pair p2 = new Pair(sc.nextLong(), sc.nextLong());
		Pair p3 = new Pair(sc.nextLong(), sc.nextLong());
		Pair p4 = new Pair(sc.nextLong(), sc.nextLong());
		
		//
		int ret1 = Pair.ccw(p1, p2, p3);
		int ret2 = Pair.ccw(p1, p2, p4);
		int ret3 = Pair.ccw(p3, p4, p1);
		int ret4 = Pair.ccw(p3, p4, p2);
		
		if(ret1 * ret2 == 0 && ret3 * ret4 == 0){
			if(p1.compareTo(p2) == -1){
				Pair temp = p1;
				p1 = p2;
				p2 = temp;
			}
			if(p3.compareTo(p4) == -1){
				Pair temp = p3;
				p3 = p4;
				p4 = temp;
			}
			if(p1.equals(p4) || p2.equals(p3))
				System.out.println(1);
			else if(p2.compareTo(p3) != p1.compareTo(p4))
				System.out.println(1);
			else
				System.out.println(0);
		}
		else if(ret1 * ret2 <= 0 && ret3 * ret4 <= 0){
			System.out.println(1);
		}
		else
			System.out.println(0);
		
		sc.close();
	}
}

class Pair implements Comparable<Pair>{
	long i, j;
	
	Pair(long i, long j){
		this.i = i;	this.j = j;
	}
	
	public static int ccw(Pair p1, Pair p2, Pair p3){
		// p1p2 X p1p3
		long ret = 1L*(p2.i - p1.i)*(p3.j - p1.j) - 1L*(p3.i - p1.i)*(p2.j - p1.j);
		
		if(ret > 0L)			//CCW
			return 1;
		else if(ret == 0L)	//paraller?
			return 0;
		return -1;			//CW
	}
	
	@Override
	public boolean equals(Object p){
		return this.i == ((Pair)p).i && this.j == ((Pair)p).j;
	}
	
	@Override	
	public int compareTo(Pair p){
		if(this.i == p.i && this.j == p.j)
			return 0;
		if(this.j < p.j)
			return -1;
		else if(this.j == p.j && this.i < p.i)
			return -1;
		return 1;
	}
	
}
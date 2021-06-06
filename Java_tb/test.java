import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		Pair p1 = new Pair(0, 1);
		Pair p2 = new Pair(1, -1);
		
		System.out.println(Pair.angle(p1, p2));
	}
}

class Pair{
	int i, j;
	
	Pair(int i, int j){
		this.i = i;	this.j = j;
	}
	
	
	static double distance(Pair p1, Pair p2){
		int xd2 = (int)Math.pow((p1.i - p2.i), 2);
		int yd2 = (int)Math.pow((p1.j - p2.j), 2);
		return Math.sqrt(xd2+yd2);
	}
	
	public double distanceFromZero(){
		return distance(this, new Pair(0, 0));
	}
	
	static double angle(Pair u1, Pair u2){
		return Math.acos(((u1.i * u2.i) + (u1.j * u2.j))/(u1.distanceFromZero() * u2.distanceFromZero()));
	}
}
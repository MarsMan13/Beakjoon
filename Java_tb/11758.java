import java.util.*;
import java.io.*;

class Main{
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Pair p1 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(bf.readLine());
		Pair p2 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(bf.readLine());
		Pair p3 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	
		//
		int ret = Pair.CCW(p1, p2, p3);
		if(0 < ret)
			System.out.println(1);
		else if(ret < 0)
			System.out.println(-1);
		else
			System.out.println(0);
	}
}

class Pair{
	
	static int CCW(Pair p1, Pair p2, Pair p3){
		return (p2.i - p1.i)*(p3.j - p2.j) - (p3.i - p2.i)*(p2.j - p1.j);
	}
	
	int i, j;

	Pair(int i, int j){
		this.i = i;	this.j = j;
	}
}

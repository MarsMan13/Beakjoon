import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
	}
}

class Pair implements Comparable<Pair>{
	int i, j;

	public int compareTo(Pair p){
		if(this.i == p.i)
			return this.j - p.j;
		return this.i - this.j;
	}
}
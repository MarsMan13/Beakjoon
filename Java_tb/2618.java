import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static int W;
	static Accident[] ac = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		ac = new Accident[W+1];
		
		for(int w = 1; w<=W; w++){
			st = new StringTokenizer(bf.readLine());
			int temp_i = Integer.parseInt(st.nextToken());
			int temp_j = Integer.parseInt(st.nextToken());
			ac[w] = new Accident(temp_i, temp_j);
		}
		// END OF INIT
		
	}
}

class Accident{
	int i, j;
	Accident(int i, int j){
		this.i = i;	this.j = j;
	}
}
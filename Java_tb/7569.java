import java.util.*;
import java.io.*;



class Main{
	
	static int N, M, H;
	static Tomato[][][] box = null;
	
	public static void main(Strig[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		for(int h = 0; h<H; h++){
			for(int m = 0; m<M; m++){
				st = new StringTokenizer(bf.readLine());
				for(int n = 0; n<N; n++){
					
				}
			}
		}
	}
}

class Tomato{
	int state;
	int visited = 0;
	Tomato(int state){
		this.state = state;
	}
}
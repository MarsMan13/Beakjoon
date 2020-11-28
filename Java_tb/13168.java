import java.util.*;
import java.io.*;



class Main{


	static int N;	// cities number
	static int R;	// neilro cost
	static int M;	// visited cities
	static String[] cities;

	public static void main(String[] args) throws IOException {


		BufferedRaeder bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		cities = new String[N+1];
		R = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			cities[i] = st.nextToken();	
		}

		M = Integer.parseInt()


	}
}

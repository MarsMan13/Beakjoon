import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		TreeSet<Integer> set = new TreeSet<>();
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<M; i++)
			set.add(Integer.parseInt(st.nextToken()));
		
		int count = 0;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Integer floor = set.floor(x);
			Integer ceiling = set.ceiling(x);
			if((floor != null && Math.abs(floor - x) + y <= L) || (ceiling != null && Math.abs(ceiling - x) + y <= L)){
				count++;
			}
		}
		System.out.println(count);
	}
}
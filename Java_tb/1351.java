import java.util.*;
import java.io.*;


class Main{
	
	static long N, P, Q;
	static TreeMap<Long, Long> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		//
		map.put(0L, 1L);
		def(N);
		System.out.println(map.get(N));
	}
	
	public static void def(long index){
		if(map.containsKey(index))
			return;
		//
		if(!map.containsKey(index/P))
			def(index/P);
		long left = map.get(index/P);
		if(!map.containsKey(index/Q))
			def(index/Q);
		long right = map.get(index/Q);
		map.put(index, left + right);
	}
}
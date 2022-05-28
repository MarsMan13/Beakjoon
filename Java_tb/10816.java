import java.util.*;
import java.io.*;


class Main{
	
	static int N = 0, M = 0;
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			int v = Integer.parseInt(st.nextToken());
			Integer gotten = map.get(v);
			if(gotten == null)
				gotten = 0;
			map.put(v, gotten+1);
		}
		
		// END OF INIT
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++){
			int v = Integer.parseInt(st.nextToken());
			Integer gotten = map.get(v);
			if(gotten == null)
				gotten = 0;
			sb.append(gotten);
			sb.append(" ");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}


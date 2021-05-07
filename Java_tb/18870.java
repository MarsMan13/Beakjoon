import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] ary = new int[N];
		TreeSet<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++){
			ary[i] = Integer.parseInt(st.nextToken());
			set.add(ary[i]);
		}
		// 
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++){
			sb.append(Collections.binarySearch(list, ary[i]));
			sb.append(" ");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}


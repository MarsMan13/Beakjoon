import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> cheeting = new HashMap<>();
		
		for(int i = 1; i<=N; i++){
			String name = bf.readLine();
			cheeting.put(Integer.toString(i), name);
			cheeting.put(name, Integer.toString(i));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=M; i++){
			String question = bf.readLine();
			sb.append(cheeting.get(question));
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
		
	}
}
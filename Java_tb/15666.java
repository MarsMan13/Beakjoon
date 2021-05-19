import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static List<Integer> inputs = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++)
			set.add(Integer.parseInt(st.nextToken()));
		inputs = new ArrayList<>(set);
		Collections.sort(inputs);
		
		def1(0, 0, new int[M]);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();	bw.close();
	}
	
	public static void def1(int start, int depth, int[] result){
		if(depth == M){
			for(int i : result){
				sb.append(i);	sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<inputs.size(); i++){
			result[depth] = inputs.get(i);
			def1(i, depth+1, result);
		}
	}
}






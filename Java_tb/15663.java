import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static LinkedList<Integer> inputs = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inputs = new LinkedList<>();
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++)
			inputs.add(Integer.parseInt(st.nextToken()));
	
		Collections.sort(inputs);
		
		def1(new LinkedList<Integer>());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
		
	}
	
	public static void def1(LinkedList<Integer> list){
		if(list.size() == M){
			for(int i : list){
				sb.append(i);
				sb.append(" ");
			}
			sb.append("\n");
		}
		int size = inputs.size();
		int before = -1;
		for(int i = 0; i<size; i++){
			if(before == inputs.get(i))
				continue;
			int temp = inputs.remove(i);
			before = temp;
			list.add(temp);
			def1(list);
			list.remove(list.size() - 1);
			inputs.add(i, temp);
		}
	}
}





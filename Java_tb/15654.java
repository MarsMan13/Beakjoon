import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static int[] inputs = null;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		inputs = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<N; i++)
			inputs[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(inputs);
		def1(0, M, new LinkedList<Integer>());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
		bf.close();
		
	}
	
	public static void def1(int start, int rest, LinkedList<Integer> list){
		if(rest == 0){
			def2(list, new LinkedList<Integer>());
		}
		else{
			for(int i = start; i<=N-rest; i++){
				list.add(inputs[i]);
				def1(i+1, rest-1, list);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void def2(LinkedList<Integer> list2, LinkedList<Integer> list3){
		int length = list2.size();
		if(list3.size() == M){
			for(int i : list3){
				sb.append(i);	sb.append(" ");
			}
			sb.append("\n");
		}
		for(int i = 0; i<length; i++){
			int temp = list2.remove(i);
			list3.add(temp);
			def2(list2, list3);
			list3.remove(list3.size() - 1);
			list2.add(i, temp);
		}
	}
	
}




import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=N; i++){
			queue.offer(i);
		}
	
		List<Integer> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			for(int i = 0; i<K-1; i++){
				queue.offer(queue.poll());
			}
			result.add(queue.poll());
		}
		sb.append("<");
		for(int i = 0; i<result.size(); i++){
			sb.append(result.get(i));
			if(i != result.size()-1)
				sb.append(", ");
		}
		sb.append(">");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();	bw.close();
	}
}


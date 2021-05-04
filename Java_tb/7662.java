import java.util.*;
import java.io.*;


class Main{
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			st = new StringTokenizer(bf.readLine());
			int numCom = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> queueForBig = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> queueForSml = new PriorityQueue<>();
			
			for(int c = 0; c < numCom; c++){
				st = new StringTokenizer(bf.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")){
					queueForBig.offer(value);
					queueForSml.offer(value);
				}
				else if(command.equals("D")){
					if(value == 1){
						queueForBig.poll();
					}
					else if(value == -1){
						queueForSml.poll();
					}
				}
			}
			List<Integer> resultBig = new ArrayList<>(queueForBig);
			List<Integer> resultSml = new ArrayList<>(queueForSml);
			resultBig.retainAll(resultSml);
			if(resultBig.isEmpty()){
				sb.append("EMPTY");
				sb.append("\n");
				continue;
			}
			Collections.sort(resultBig);
			sb.append(resultBig.get(resultBig.size() - 1));
			sb.append(" ");
			sb.append(resultBig.get(0));
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}


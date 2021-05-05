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
			int comNum = Integer.parseInt(st.nextToken());
		
			TreeMap<Long, Integer> higherMap = new TreeMap<>(Collections.reverseOrder());
			TreeMap<Long, Integer> lowerMap = new TreeMap<>();
			
			for(int c = 0; c<comNum; c++){
				st = new StringTokenizer(bf.readLine());
				String command = st.nextToken();
				
				if(command.equals("I")){
					long value = Long.parseLong(st.nextToken());
					if(higherMap.containsKey(value)){
						higherMap.put(value, higherMap.get(value)+1);
						lowerMap.put(value, lowerMap.get(value)+1);
					}
					else{
						higherMap.put(value, 1);
						lowerMap.put(value, 1);
					}
				}
				else if(command.equals("D")){
					int option = Integer.parseInt(st.nextToken());
					if(option == 1 && 0 < higherMap.size()){
						Long target = higherMap.firstKey();
						if(higherMap.get(target) == 1){
							higherMap.remove(target);
							lowerMap.remove(target);
						}
						else{
							higherMap.put(target, higherMap.get(target) - 1);
							lowerMap.put(target, lowerMap.get(target) - 1);
						}
					}
					else if(option == -1 && 0 < lowerMap.size()){
						Long target = lowerMap.firstKey();
						if(lowerMap.get(target) == 1){
							lowerMap.remove(target);
							higherMap.remove(target);
						}
						else{
							lowerMap.put(target, lowerMap.get(target) - 1);
							higherMap.put(target, higherMap.get(target) - 1);
						}
					}
				}
			}
			
			if(higherMap.size() == 0){
				sb.append("EMPTY");
				sb.append("\n");
			}
			else{
				sb.append(higherMap.firstKey());
				sb.append(" ");
				sb.append(lowerMap.firstKey());
				sb.append("\n");
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
import java.util.*;
import java.io.*;


class Main{
	
	static int N, M;
	static List<String> neverListened = new ArrayList<>();
	static List<String> neverSeen = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
	
		for(int i = 0; i<N; i++){
			neverListened.add(bf.readLine());
		}
		for(int i = 0; i<M; i++){
			neverSeen.add(bf.readLine());
		}
		
		// END OF INIT
		
		Collections.sort(neverListened);
		Collections.sort(neverSeen);
	
		List<String> result = new ArrayList<>();
		
		int i = 0;	int j = 0;
		while(i<N && j<M){
			if(neverListened.get(i).compareTo(neverSeen.get(j)) == 0){
				result.add(neverListened.get(i));
				i++;	j++;
			}
			else if(neverListened.get(i).compareTo(neverSeen.get(j)) < 0){
				i++;
			}
			else{
				j++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result.size());	sb.append("\n");
		for(String s : result){
			sb.append(s);	sb.append("\n");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}



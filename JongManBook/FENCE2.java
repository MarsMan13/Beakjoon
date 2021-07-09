import java.util.*;
import java.io.*;


class Main{
	
	static int[] input = new int[1];
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int[] input = new int[N+1];
			int[] heightDB = new int[10001]; 
			for(int i = 1; i<=N; i++){
				input[i] = Integer.parseInt(st.nextToken());
				heightDB[input[i]]++;
			}
			//
			int max = 0;
			for(int h = 1; h<=10000; h++){
				if(heightDB[h] == 0)	continue;
				int len = 0;
				for(int i = 1; i<=N; i++){
					if(h<=input[i]){
						len++;
						if(max < len * h)
							max = len * h;
					}
					else	len = 0;
				}
			}
			sb.append(max);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
}
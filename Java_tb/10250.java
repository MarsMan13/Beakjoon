import java.util.*;
import java.io.*;



class Main{
	
	static int T = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N%H;
			if(floor == 0)	floor = H;
			int ho = (N+H-1)/H;
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(floor);
			if(ho < 10){
				sb2.append("0");
				sb2.append(ho);
			}
			else{
				sb2.append(ho);
			}
			
			sb.append(sb2.toString());
			sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
import java.util.*;
import java.io.*;



class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int set = 0;
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			String command = st.nextToken();
			int p = 0;
			switch(command){
				case "add":
					p = Integer.parseInt(st.nextToken());
					set = set | (1 << (p-1));
					break;
				case "remove":
					p = Integer.parseInt(st.nextToken());
					set = set & ~(1 << (p-1));
					break;
				case "check":
					p = Integer.parseInt(st.nextToken());
					int check = set & (1 << (p-1));
					if(check != 0)
						sb.append("1\n");
					else
						sb.append("0\n");
					break;
				case "toggle":
					p = Integer.parseInt(st.nextToken());
					set = set ^ (1 << (p-1));
					break;
				case "all":
					set = 1048575;
					break;
				case "empty":
					set = 0;
					break;
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
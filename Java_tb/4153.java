import java.util.*;
import java.io.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int side1 = Integer.parseInt(st.nextToken());
			int side2 = Integer.parseInt(st.nextToken());
			int side3 = Integer.parseInt(st.nextToken());
			if(side1 == 0 && side2 == 0 && side3 == 0)
				break;
			int maxSide = Math.max(side1, Math.max(side2, side3));
			int maxSidePow = maxSide * maxSide;
			int totPow = side1 * side1;
			totPow += side2 * side2;
			totPow += side3 * side3;
			totPow -= maxSidePow;
			
			if(maxSidePow == totPow){
				sb.append("right\n");
			}
			else
				sb.append("wrong\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
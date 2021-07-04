import java.util.*;
import java.io.*;


class Main{
	
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t<T; t++){
			result = -1;
			st = new StringTokenizer(bf.readLine());
			int[] curTime = new int[16];
			for(int i = 0; i<16; i++){
				curTime[i] = Integer.parseInt(st.nextToken());
			}
			def(0, curTime, 0);
			sb.append(result);	sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush(); bw.close();
	}
	
	public static void def(int step, int[] curTime, int click){
		
		if(step == 10){
			for(int time : curTime){
				if(time != 12){
					return;
				}
			}
			if(result == -1 ||click < result)
				result = click;
			return;
		}
		
		int[] curSwitch = switchs[step];
		def(step+1, curTime, click);
		for(int i = 1; i<=3; i++){
			setTime(curSwitch, curTime);
			def(step+1, curTime, click+i);
		}
		setTime(curSwitch, curTime);
	}
	
	public static void setTime(int[] curSwitch, int[] curTime){
		for(int clock : curSwitch){
			curTime[clock] += 3;
			if(curTime[clock] == 15)
				curTime[clock] = 3;
		}
	}
	
	static int[][] switchs = new int[][]{
		{0, 1, 2},
		{3, 7, 9, 11},
		{4, 10, 14, 15},
		{0, 4, 5, 6, 7},
		{6,7,8,10,12},
		{0,2,14,15},
		{3,14,15},
		{4,5,7,14,15},
		{1,2,3,4,5},
		{3,4,5,9,13}
	};
}
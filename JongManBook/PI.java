import java.util.*;
import java.io.*;


class Main{
	
	static int length = 0;
	static int[] input = null;
	static int[] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			String line = bf.readLine();
			length = line.length();
			input = new int[length];
			for(int i = 0; i<length; i++)
				input[i] = (int)(line.charAt(i) - '0');
			
			dp = new int[length+1];
			sb.append(def(0));	sb.append("\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
	
	public static int def(int i){
		if(length <= i)		return 0;
		if(length - i < 2)	return -1;
		
		if(dp[i] != 0)	return dp[i];
		
		int ret = 987654321;
		for(int j = 2; j<=4 && i+j<length; j++){
			int temp = def(i+j+1);
			if(temp == -1)	continue;
			temp += testor(i, i+j);
			if(temp < ret)	ret = temp;
		}
		return dp[i] = ret;
	}
	
	public static int testor(int start, int end){
		{
			int before = input[start];
			int flag = 0;
			for(int i = start; i<=end; i++){
				if(before != input[i]){
					flag = 1;
					break;
				}
				before = input[i];
			}
			if(flag == 0)	return 1;
		}
		{
			int flag = 0;
			int before = input[start];
			int gap = input[start+1] - input[start];
			for(int i = start+1; i<=end; i++){
				if(input[i] - before != gap){
					flag = 1;
					break;
				}
				before = input[i];
			}
			if(flag == 0){
				if(gap == 1 || gap == -1)	return 2;
				return 5;
			}
		}
		{
			int flag = 0;
			for(int i = start+2; i<=end; i++){
				if(input[i-2] != input[i]){
					flag = 1;
					break;
				}
			}
			if(flag == 0)	return 4;
		}
		return 10;
	}
}
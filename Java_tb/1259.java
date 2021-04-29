import java.util.*;
import java.io.*;


class Main{
	
	static List<String> inputs = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = bf.readLine();
			if(line.equals("0"))
				break;
			inputs.add(line);
		}
		// END OF INIT
		
		StringBuilder sb = new StringBuilder();
		for(String s : inputs){
			int length = s.length();
			int end = length / 2;
			if(length % 2 == 1){
				end--;	
			}
			
			length--;
			int flag = 0;
			for(int i = 0; i<=end; i++){
				if(s.charAt(i) != s.charAt(length-i)){
					flag = 1;
				}
			}
			if(flag == 0)
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
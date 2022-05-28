import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++){
			String commands = bf.readLine();
			int n  = Integer.parseInt(bf.readLine());
			int[] array = parser(bf.readLine(), n);
			
			int head = 0;
			int tail = array.length - 1;	// == n
			int flag = 1;
			
			int errorFlag = 0;
			for(int i = 0; i<commands.length(); i++){
				char command = commands.charAt(i);
			
				if(command == 'R'){
					int temp = head;
					head = tail;
					tail = temp;
					flag *= -1;
				}
				else if(command == 'D'){
					if(head*flag > tail*flag){
						errorFlag = 1;
						break;
					}
					if(flag == 1){
						head += flag;
					}
					else if(flag == -1){
						head += flag;
					}
				}
			}
			if(errorFlag == 1){
				sb.append("error");
				sb.append("\n");
				continue;
			}
			sb.append("[");
			while(head*flag <= tail*flag){
				sb.append(array[head]);
				if(head != tail){
					sb.append(",");
				}
				head += flag;
			}
			sb.append("]");
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int[] parser(String s, int n){
		int[] newArray = new int[n];
		StringTokenizer st = new StringTokenizer(s.substring(1, s.length()-1), ",");
		for(int i = 0; i<n; i++){
			newArray[i] = Integer.parseInt(st.nextToken());
		}
		return newArray;
	}
}

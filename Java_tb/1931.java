import java.util.*;
import java.io.*;



class Main{
	
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i<N; i++){
			
		}
	}
}


class Meeting implements <Meeting>{
	int start;
	int end;
	
	
	@Override
	public int compareTo(Meeting o){
		return this.end - o.end;
	}
}
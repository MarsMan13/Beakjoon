import java.util.*;
import java.io.*;

class Main{

	static int[] data = new int[1000001];

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());


		long token = 2;
		long tt = token * token;
		while(tt <= max){
			long rest = min / tt;
			for(long i = rest * tt; i<= max; i += tt){
				if(min <= i && i<= max){
					data[(int)(i - min)] = 1;
				}
			}
			token++;
			tt = token * token;
		}

		int count = 0;
		for(int i = 0; i<max-min+1; i++){
			if(data[i] == 0){
				count++;
			}
		}
		System.out.println(count);

	}
}

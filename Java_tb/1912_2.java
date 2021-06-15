import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i<n; i++){
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			if(max < sum)
				max = sum;
			if(sum <= 0)
				sum = 0;
		}
		System.out.println(max);
	}
}
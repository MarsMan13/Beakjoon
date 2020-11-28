import java.util.*;
import java.io.*;


class Main{

	static int n;
	static int m;
	static int[] road;
	static int ans = 0;
	static int[] ret;

	public static void main(String[] args) throws IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		road = new int[n+1];
		m = Integer.parseInt(st.nextToken());
		ret = new int[m+1];

		st = new StringTokenizer(bf.readLine());
		int pre = 0;
		for(int i = 1; i<=n; i++){
			road[i] = Integer.parseInt(st.nextToken());
			if(road[i] == 1){
				if(pre == 0){
					ans++;
				}
			}
			pre = road[i];
		}

		int zeroCount = 0;
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			int type = Integer.parseInt(st.nextToken());

			if(type == 0){
				ret[zeroCount++] = ans;	
			}
			else{
				int target = Integer.parseInt(st.nextToken());
				reCalc(target);
			}
		}
		

		for(int i = 0; i<zeroCount; i++){
			System.out.println(ret[i]);
		}


	}

	static void reCalc(int index){

		if(road[index] == 1)	
			return;

		road[index] = 1;
		
		if(index != 1 && index != n){
			if(road[index-1] == 1 && road[index+1] == 1){
				ans--;
				return;
			}
		}
		
		if(index != 1){
			if(road[index-1] == 1)
				return;
		}

		if(index != n){
			if(road[index+1] == 1)
				return;
		}

		ans++;
		
		return;
	}
}

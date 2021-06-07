import java.util.*;
import java.io.*;


class Main{
	
	static int N, K;
	static int[] input = null;
	static int[] needed = null;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	K = Integer.parseInt(st.nextToken());
		input = new int[N];
		//
		needed = new int[]{'a'-'a', 'c'-'a', 'i'-'a', 'n'-'a', 't'-'a'};
		
		for(int i = 0; i<N; i++){
			String line = bf.readLine();
			for(int j = 0; j<line.length(); j++){
				int index = line.charAt(j) - 'a';
				input[i] = input[i] | (1 << index);
			}
		}
		//
		if(K < 5){
			System.out.println(0);
			System.exit(0);
		}
		
		int initSet = 0;
		for(int i : needed){
			initSet = initSet | (1 << i);
		}
		makeSet(initSet, 0, K-5);
		
		System.out.println(max);
		
	}

	public static void makeSet(int set, int index, int length){
		
		if(26 < index)
			return;
		if(Long.bitCount(set) == K){
			def1(set);
			return;
		}
		else{
			if((set >> index)%2 == 1){
				makeSet(set, index+1, length);
			}
			else{
				set = set | (1 << index);
				makeSet(set, index+1, length+1);
				//
				set = set & ~(1 << index);
				makeSet(set, index+1, length);
			}
		}
	}
	
	public static void def1(int set){
		int tempCount = 0;
		for(int target : input){
			int flag = 0;
			for(int i = 0; i<26; i++){
				if(((target >> i) % 2) == 1 && ((set >> i) % 2) == 0){
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				tempCount++;
		}
		if(max < tempCount)
			max = tempCount;
	}
}



import java.util.*;
import java.io.*;


class Main{

	static final int INF = 10000000;
	
    public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		List<Integer> order = new ArrayList<>();	order.add(0);
		while(true){
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0)	break;
			order.add(temp);
		}
		int[][] dp = new int[order.size()+1][25];
        for(int j = 1; j<25; j++)	dp[0][j] = INF;
		for(int j = 0; j<25; j++){
			dp[1][j] = INF;
			if()
		}
		for(int i = 2; i<=order.size(); i++){
			int cur = order.get(i);
			int x1 = order.get(i-1);
			int x2 = 0;
			if(2<=i)
				x2 = order.get(i-2);
			// move left foot
			int new_left = cur;	int new_right = 
			
		}
		
	
		
	}
}

class Step{
	int left = 0, right = 0;
	Step(int left, int right){
		this.left = left;	this.right = right;
	}
	
	Step(int index){
		for(int i = 0; i<5; i++){
			for(int j = 0; j<5; j++){
				if(stepToIndex[i][j] == index){
					this.left = i;	this.right = j;
				}
			}
		}
	}
	
	static boolean movable(Step s1, Step s2){
		if(s1.left == s2.left || s1.right == s2.right)	return true;
		return false;
	}
	
	static int getCost(Step s1, Step s2){
	
		if(!movable(s1, s2))	return -1;
		
		int v1 = s1.left;	int v2 = s2.left;
		if(s1.right == s2.right)	// focus on right
			v1 = s1.right;	v2 = s2.right;
		//
		if(v1 == v2)	return 1;
		if(v1 == 0)		return 2;
		if(Math.abs(v1 - v2) == 2)	return 4;
		return 3;
	}
	
	
	
	static int[][] stepToIndex = {
		{0, 5, 10, 15, 20},
		{1, 6, 11, 16, 21},
		{2, 7, 12, 17, 22},
		{3, 8, 13, 18, 23},
		{4, 9, 14, 19, 24},
	};
	
	@Override
	public boolean equals(Object o){
		return this.left == ((Step)o).left && this.right == ((Step)o).right;
	}
}






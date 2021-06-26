import java.util.*;
import java.io.*;


class Main{

	static final int INF = 10000000;
	
    public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		List<Integer> order = new ArrayList<>();
		while(true){
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0)	break;
			order.add(temp);
		}
		int[][] dp = new int[13][order.size()+1];
        for(int i = 1; i<10; i++)	dp[i][0] = INF;
	
	
		int[] ret = availableSteps(1);
		for(int )
		// for(int i = 1; i<=order.size(); i++){
		// 	int xStep = order.get(i-1);
		// 	int curStep = order.get(i);
			
		// 	int[] xSteps = availableSteps(xStep);
		// 	for(s1 : xSteps){
		// 		int[] curSteps = availableSteps(curStep);
		// 		for(s2 : curSteps){
					
		// 		}
		// 	}
			
		// }
	}
	
	static int[] indexToStep(int i){
		int[] ret = new int[2];
		
		 return ret;
	}
	
	static int stepToIndex(int i, int j){
		if(i == j)	return -1;
		int ret = (i-1) * 3;
		for(int k = 1; k<=j; k++){
			if(i == k)	continue;
			ret++;
		}
		return ret;
	}
	
	static int getCost(int[] s1, int[] s2){
		int i = 0;	int j = 0;
		loop:
		for(;i<2; i++){
			for(;j<2; j++){
				if(s1[i] == s2[j])
					break loop;
			}
		}
		//
		i = (i+1)%2;	j = (j+1)%2;
		if(s1[i] == s2[j])
			return 1;
		if(s1[i] == 0 || s2[j] == 0)
			return 2;
		if(Math.abs(s1[i] - s2[j]) == 2)
			return 4;
		return 3;
	}
	
	static int[] availableSteps(int s){
		int[] ret = new int[6];
		int index = 0;
		for(int j = 1; j<=4; j++){
			if(s == j)	continue;
			ret[index++] = stepToIndex(s, j);
		}
		for(int i = 1; i<=4; i++){
			if(s == i)	continue;
			ret[index++] = stepToIndex(i, s);
		}
		return ret;
	}
}

class Step{
	int left, right;
	Step(int left, int right){
		this.left = left;	this.right = right;
	}
	
}

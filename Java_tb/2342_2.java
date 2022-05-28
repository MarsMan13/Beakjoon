import java.util.*;
import java.io.*;


class Main{
	
	static List<Integer> input = new ArrayList<>();
	static Step[][] dp = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		while(true){
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0)	break;
			input.add(temp);
		}
		dp = new Step[input.size() + 1][25];
		dp[0][0] = new Step(0, 0);	
		for(int i = 1; i<=input.size(); i++){
			int curStep = input.get(i-1);
			//
			for(int j = 0; j<=24; j++){
				if(dp[i-1][j] == null)	continue;
				
				Step beforeStep = dp[i-1][j];
				
				Step newStep1 = new Step(beforeStep.steps[0], curStep);
				newStep1.cost += beforeStep.cost + beforeStep.getCost(newStep1);
				
				Step newStep2 = new Step(curStep, beforeStep.steps[1]);
				newStep2.cost += beforeStep.cost + beforeStep.getCost(newStep2);
				
				if(newStep1.cost != -1)
					if(dp[i][newStep1.getIndex()] == null || newStep1.cost < dp[i][newStep1.getIndex()].cost)
						dp[i][newStep1.getIndex()] = newStep1;
				
				if(newStep2.cost != -1)
					if(dp[i][newStep2.getIndex()] == null || newStep2.cost < dp[i][newStep2.getIndex()].cost)
						dp[i][newStep2.getIndex()] = newStep2;
			}
		}
		
		int min = 10000000;
		for(int j = 0; j<=24; j++){
			if(dp[input.size()][j] != null && dp[input.size()][j].cost < min)
				min = dp[input.size()][j].cost;
		}
		System.out.println(min);
	}
}

class Step{
	
	int[] steps = new int[2];
	int cost = 0;
	Step(int left, int right){
		this.steps[0] = left;	this.steps[1] = right;
	}
	
	public int getIndex(){
		return steps[0] * 5 + steps[1];
	}
	
	public int getCost(Step s){

		int i = 0, j = 0;
		loop:
		for(i = 0; i<=1; i++){
			for(j = 0; j<=1; j++){
				if(this.steps[i] == s.steps[j])
					break loop;
			}
		}
		if(i == 2 || j == 2)
			return -1;
		//
		i = (i+1)%2;	j = (j+1)%2;
		if(this.steps[i] == 0)	return 2;
		if(this.steps[i] == s.steps[j])	return 1;
		if(Math.abs(this.steps[i] - s.steps[j]) == 2)	return 4;
		return 3;
	}
	
	public static int getIndex(int left, int right){
		return left * 5 + right;
	}	
}



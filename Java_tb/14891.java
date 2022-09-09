import java.util.*;
import java.io.*;

class Main{
	
	static int[][] gears = new int[4][8];	// left : 6, right : 2

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i<4; i++){
			String line = bf.readLine();
			for(int j = 0; j<8; j++){
				gears[i][j] = line.charAt(j);
			}
		}
		int K = Integer.parseInt(bf.readLine());
		for(int k = 0; k<K; k++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int targetGearIndex = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());	// 1 : clock wise
			// LEFT GEARS
			int[] isOp = new int[4];
			isOp[targetGearIndex] = direction;
			for(int g = targetGearIndex-1; 0<=g; g--){
				if(gears[g][2] != gears[g+1][6]){
					isOp[g] = isOp[g+1] * -1; 
				}
				else{
					break;
				}
			}
			// RIGHT GEARS
			for(int g = targetGearIndex+1; g<4; g++){
				if(gears[g][6] != gears[g-1][2]){
					isOp[g] = isOp[g-1] * -1;
				}
				else{
					break;
				}
			}

			for(int i = 0; i<4; i++){
				if(isOp[i] != 0){
					moveGear(i, isOp[i]);
				}
			}
		}
		int result = 0;
		int[] scores = new int[]{1,2,4,8};
		for(int i = 0; i<4; i++){
			result += (gears[i][0] == '1') ? scores[i] : 0;
		}	
		System.out.println(result);
	}

	public static void moveGear(int targetGearIndex, int direction){
		int[] gear = gears[targetGearIndex];
		if(direction == 1){
			int temp = gear[7];
			for(int i = 7; 0<i; i--){
				gear[i] = gear[i-1];
			}
			gear[0] = temp;
		}
		else if(direction == -1){
			int temp = gear[0];
			for(int i = 0; i<7; i++){
				gear[i] = gear[i+1];
			}
			gear[7] = temp;
		}
	}
}
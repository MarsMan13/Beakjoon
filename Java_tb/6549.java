import java.util.*;
import java.io.*;


class Main{

	static int T = 0;
	static int size = 0;
	static int[] input = null;
	static int[][] mem = null;
	static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int finFlag = 0;
		while(finFlag == 0){
			T++;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			size = st.countTokens();
			input = new int[size];
			mem = new int[size][size];

			for(int t = 0; st.hasNext(); t++){
				int temp = Integer.parseInt(st.nextToken());
				
				if(t == 0 || temp == 0){
					finFlag = 1;
					break;
				}

				input[t] = temp;
			}
			// END OF INIT

		}

	}

	static int def1(int index){
		
		//Backward
		int maxValue = input[index] * 1;
		int minHeight = input[index];
		for(int i = index-1; 0<=i; i--){
			if(input[i] == 0)
				break;
			if(input[i] < minHeight){
				minHeight = input[i];
			}
			int temp = minHeight * (index - i + 1);
			if(maxValue < temp){
				maxValue = temp;
			}
			mem[i][index] = temp;
		}

	}
}

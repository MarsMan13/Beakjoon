import java.util.*;
import java.io.*;



class Main{

	static int n;
	static int result = 987654321;
	static int[] pp;
	static int[] zero;
	static int zeroCount = 0;
	static int[][] w;
	static int[] white;
	static int[] black;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		pp = new int[n+1];
		zero = new int[n+1];
		w = new int[n+1][n+1];
		white = new int[n+1];
		black = new int[n+1];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<=n; i++){
			int temp = Integer.parseInt(st.nextToken());
			pp[i] = temp;
			if(temp == 0){
				zero[zeroCount++] = i;
			}
		}

		for(int i = 1; i<=n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 1; j<=n; j++){
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// END OF INIT
		//

		if(zeroCount != 0){
			dfs(0);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		sb.append(result);
		sb.append("\n");
		for(int i = 0; i<=n; i++){
			if(white[i] == 0)	break;
			sb.append(white[i]);
			sb.append(" ");
		}
		sb.append("\n");
		for(int i = 0; i<=n; i++){
			if(black[i] == 0)	break;
			sb.append(black[i]);
			sb.append(" ");
		}
		sb.append("\n");

		bw.write(sb.toString());

		bf.close();
		bw.close();
	}

	static void dfs(int index){

		if(zeroCount <= index){
			testFunc();
			return;
		}

		int tempWhite = zero[index];

		pp[tempWhite] = 1;
		dfs(index+1);
		pp[tempWhite] = 2;
		dfs(index+1);
		pp[tempWhite] = 0;
		

	}

	static void testFunc(){

		int temp = 0;
		for(int i = 1; i<=n; i++){
			for(int j = i+1; j<=n; j++){
				if(pp[i] != pp[j]){
					temp += w[i][j];
				}
			}
		}

	
		
		if(temp < result){
			result = temp;
			int wIndex = 0;
			int bIndex = 0;
			for(int i = 1; i<=n; i++){
				if(pp[i] == 1){
					white[wIndex++] = i;
				}
				else if(pp[i] == 2){
					black[bIndex++] = i;
				}
			}
			white[wIndex] = 0;
			black[bIndex] = 0;
		}

	}
}

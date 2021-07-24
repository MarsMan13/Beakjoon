import java.util.*;
import java.io.*;


class Main{
	
	static int m, q;
	static String[] words = null;
	static double[] startPer = null;
	static double[][] mat1 = null;	// i with j
	static double[][] mat2 = null;	// classifier
	// variable for each Test case
	static int length = 0;
	static int[] word = null;
	static double[][] dp = null;
	static int[][] dp2 = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());	q = Integer.parseInt(st.nextToken());
		words = new String[m];		startPer = new double[m];
		mat1 = new double[m][m];	mat2 = new double[m][m];
		
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<m; i++) words[i] = st.nextToken();
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<m; i++) startPer[i] = Double.parseDouble(st.nextToken());
		
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<m; j++){
				mat1[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		for(int i = 0; i<m; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<m; j++){
				mat2[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		
		//
		for(int qq = 0; qq<q; qq++){
			st = new StringTokenizer(bf.readLine());
			length = Integer.parseInt(st.nextToken());
			word = new int[length];	
			dp = new double[length][m];	dp2 = new int[length][m];
			//
			for(int i = 0; i<length; i++){
				String tempS = st.nextToken();
				for(int j = 0; j<m; j++){
					if(tempS.equals(words[j])){
						word[i] = j;
						break;
					}
				}
			}
			//
			for(int j = 0; j<m; j++)
				dp[0][j] = mat2[j][word[0]] * startPer[j];
				
			for(int i = 1; i<length; i++){
				int curR = word[i];
				for(int j = 0; j<m; j++){
					dp[i][j] = -1.0;
					for(int k = 0; k<m; k++){
						double tempPer = mat2[j][curR] * mat1[k][j];
						if(dp[i][j] < tempPer){
							dp[i][j] = tempPer;
							dp2[i][j] = k;
						}
					}    
				}
			}	
			//
			{
				StringBuilder sb2 = new StringBuilder();
				double maxPer = dp[length-1][0];
				int j = 0;
				for(int jj = 0; jj<m; jj++){
					if(maxPer < dp[length-1][jj]){
						maxPer = dp[length-1][jj];
						j = jj;
					}
				}
				sb2.insert(0, words[word[j]]);	sb2.insert(0, " ");
				for(int i = length-2; 1<=i; i--){
					j = dp2[i][j];
					sb2.insert(0, words[word[j]]);	
					if(i != 1)
						sb2.insert(0, " ");
				}
				sb.append(sb2);
			}
			sb.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}
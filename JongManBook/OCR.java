import java.util.*;
import java.io.*;


class Main{
	
	static int m, q;
	static String[] words = null;
	static double[][] mat1 = null;
	static double[][] mat2 = null;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());	q = Integer.parseInt(st.nextToken());
		words = new String[m];	mat1 = new double[m][m];	mat2 = new double[m][m];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<m; i++) word[i] = st.nextToken();
		
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
			
				
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());	bw.flush();	bw.close();
	}
}
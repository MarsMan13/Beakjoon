import java.util.*;
import java.io.*;


class Main{

	static int[][] data;

	public static void main(String[] args) throws IOException{


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		data = new int[n+1][2];

		StringTokenizer st;
		for(int i = 0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}

		//

		double score = 987654321;
		double temp;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if(i == j)	continue;
			
				int x1 = data[i][0];
				int y1 = data[i][1];
				int x2 = data[j][0];
				int y2 = data[j][1];

				temp = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

				for(int k = 0; k<n; k++){
					if(i == k || j == k)	continue;
				}
			}
		}

	}
}

import java.util.*;
import java.io.*;


class Main{
	
	static int N;
	static double[] xx;
	static double[] yy;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		
		xx = new double[N];	yy = new double[N];
		
		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			xx[i] = Double.parseDouble(st.nextToken());
			yy[i] = Double.parseDouble(st.nextToken());
		}
		
		//
		double ret = 0;
		for(int i = 1; i<N-1; i++){
			double temp = 0;
			temp += (xx[i] - xx[0]) * (yy[i+1] - yy[0]);
			temp -= (xx[i+1] - xx[0]) * (yy[i] - yy[0]);
			temp /= 2;
			ret += temp;
		}
		ret = Math.abs(ret);
		System.out.printf("%.1f\n", Math.round(ret * 100)/100.0);
	}
}
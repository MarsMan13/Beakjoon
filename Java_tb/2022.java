import java.util.*;
import java.io.*;

class Main{
	
	static double x, y, c;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Double.parseDouble(st.nextToken());
		y = Double.parseDouble(st.nextToken());
		c = Double.parseDouble(st.nextToken());
		// END OF INIT
		double left = .0;
		double right = Math.min(x, y);
		double result = .0;
		while((right - left) > 0.000001){
			double mid = (left + right) / 2.;
			result = mid;
			if(computeC(mid) >= c){
				left = mid;
			}
			else{
				right = mid;
			}
		}
		System.out.printf("%.3f\n", result);
	}

	public static double computeC(double w){
		double h1 = Math.sqrt(x * x - w * w);
		double h2 = Math.sqrt(y * y - w * w);
		return (h1 * h2) / (h1 + h2);
	}
}
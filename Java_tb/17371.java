import java.util.Scanner;


public class Main{

	static Point[] points;
	static Point result;

	public static void main(String[] args){
		new Main();
	}

	public Main(){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		points = new Point[n+1];

		for(int i = 0; i<n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();

			points[i] = new Point(x, y);
		}

		// END OF INIT
		//

		Point close;
		Point far;
		Point center;
		Point other;
		for(int i = 0; i<n; i++){
			close = points[i];
			
			outer: for(int j = 0; j<n; j++){
				if(i == j) continue;
				far = points[j];
				//
				//
				center = this.centerPoint(close, far);

				double maxLength = 
					Math.max(Math.pow((close.x - center.x), 2) + Math.pow((close.y - center.y), 2),
							Math.pow((far.x - center.x), 2) + Math.pow((far.y - center.y), 2));

				for(int k = 0; k<n; k++){
					if(k == i || k == j) continue;
					//
					other = points[k];

					if((Math.pow((other.x - center.x), 2) + Math.pow((other.y - center.y), 2)) > maxLength){
						break outer;
					}
					if((Math.pow((other.x - center.x), 2) + Math.pow((other.y - center.y), 2)) < maxLength){
						break outer;
					}
				}

				if(Main.result == null || result.avgLength > Math.sqrt(maxLength)){
					System.out.println("check");
					result = center;
					result.avgLength = Math.sqrt(maxLength);
				}
			}
		}
		System.out.println(result.x+" "+result.y);
	}

	class Point{
		int x;
		int y;
		double avgLength;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString(){
			return "x: "+this.x + ", y: "+this.y;
		}
	}
	
	Point centerPoint(Point a, Point b){
		return new Point((a.x + b.x)/2, (a.y + b.y)/2);
	}
}

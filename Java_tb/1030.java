import java.util.*;


class Main{

	static int s = 0;
	static int N = 0;
	static int K = 0;
	static int r1 = 0;
	static int r2 = 0;
	static int c1 = 0;
	static int c2 = 0;
	static int maxN = 1;
	static int maxK = 1;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		r1 = sc.nextInt()+1;
		r2 = sc.nextInt()+1;
		c1 = sc.nextInt()+1;
		c2 = sc.nextInt()+1;
		maxK = K;

		for(int i = 1; i<= s; i++){
			maxN *= N;
			if(i == s) break;
			maxK *= N;
		}

		for(int i = r1; i <= r2; i++){
			for(int j = c1; j <= c2; j++){
				if(isBlack(i, j)){
					System.out.print("1");
				}
				else{
					System.out.print("0");
				}
			}
			System.out.println();
		}
		
	}

	static boolean isBlack(int i, int j){

		int tempN = maxN;
		int tempK = maxK;

		for(int stage = s; 0<stage; stage--){
			int ii = i%tempN;
			int jj = j%tempN;
	
			int from = (tempN-tempK)/2;
			int to = tempN-from;

			if(from < ii && ii <= to){
				if(from < jj && jj <= to){
					return true;
				}
			}
			
			tempN/=N;
			tempK/=N;
		}
		return false;

	}
}

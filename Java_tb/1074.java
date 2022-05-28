import java.util.*;
import java.io.*;


class Main{

	static int[][] map = null;
	static int target_i, target_j;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// END OF INIT
	
		int width = (int)Math.pow(2, N);
	
		target_i = r+1;	target_j = c+1;
		System.out.println(search(width, 1, 1)-1);
	}
	
	
	
	public static int search(int width, int i, int j){
	
		if(width == 1){
			return 1;
		}
		
		int nextWidth = width/2;
		int cubVolume = nextWidth * nextWidth;
		int i1 = i+nextWidth;
		int j1 = j+nextWidth;
		if(target_i < i1 && target_j < j1){
			return search(nextWidth, i, j);
		}
		else if(target_i < i1 && j1 <= target_j){
			return cubVolume * 1 + search(nextWidth, i, j+nextWidth);
		}
		else if(i1 <= target_i && target_j < j1){
			return cubVolume * 2 + search(nextWidth, i+nextWidth, j);
		}
		else{
			return cubVolume * 3 + search(nextWidth, i+nextWidth, j+nextWidth);
		}
	}
}
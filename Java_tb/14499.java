import java.util.*;
import java.io.*;

class Main{

	static int N, M;
	static int[][] map = null;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());	M = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken());	int j = Integer.parseInt(st.nextToken());	
		int K = Integer.parseInt(st.nextToken());
		Dice dice = new Dice(i, j);
		map = new int[N][M];
		for(i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			for(j = 0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		// END OF INIT
		for(i = 0; i<K; i++){
			int order = Integer.parseInt(st.nextToken());
			dice.doOrder(order);
		}
	}
}

class Dice{

	int[] planes = new int[6];
	int i, j;

	Dice(int i, int j){
		this.i = i;
		this.j = j;
	}

	public void setBottom(int v){
		planes[0] = v;
	}
	public int getBottom(){
		return planes[0];
	}
	public int getTop(){
		return planes[5];
	}
	public void doOrder(int order){
		boolean flag = false;
		switch(order){
			case 1:
				flag = validateEast();
				if(flag)
					goEast();
				break;
			case 2:
				flag = validateWest();
				if(flag)
					goWest();
				break;
			case 3:
				flag = validateNorth();
				if(flag)
					goNorth();
				break;
			case 4:
				flag = validateSouth();
				if(flag)
					goSouth();
				break;
		}
		if(flag){
			System.out.println(getTop());
			if(Main.map[i][j] == 0)
				Main.map[i][j] = getBottom();
			else{
				setBottom(Main.map[i][j]);
				Main.map[i][j] = 0;
			}
		}
	}
	public boolean validateNorth(){
		return 0 < i;
	}
	public boolean validateSouth(){
		return i < Main.N - 1; 
	}
	public boolean validateWest(){
		return 0 < j;
	}
	public boolean validateEast(){
		return j < Main.M - 1;
	}

	public void goNorth(){
		int[] planes_ = new int[6];
		planes_[0] = planes[1];
		planes_[1] = planes[5];
		planes_[2] = planes[2];
		planes_[3] = planes[3];
		planes_[4] = planes[0];
		planes_[5] = planes[4];
		planes = planes_;
		i--;
	}

	public void goSouth(){
		int[] planes_ = new int[6];
		planes_[0] = planes[4];
		planes_[1] = planes[0];
		planes_[2] = planes[2];
		planes_[3] = planes[3];
		planes_[4] = planes[5];
		planes_[5] = planes[1];
		planes = planes_;
		i++;
	}
	
	public void goWest(){
		int[] planes_ = new int[6];
		planes_[0] = planes[3];
		planes_[1] = planes[1];
		planes_[2] = planes[0];
		planes_[3] = planes[5];
		planes_[4] = planes[4];
		planes_[5] = planes[2];
		planes = planes_;
		j--;
	}

	public void goEast(){
		int[] planes_ = new int[6];
		planes_[0] = planes[2];
		planes_[1] = planes[1];
		planes_[2] = planes[5];
		planes_[3] = planes[0];
		planes_[4] = planes[4];
		planes_[5] = planes[3];
		planes = planes_;
		j++;
	}
}
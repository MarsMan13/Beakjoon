
public class test1{

	public static void main(String[] args){

		for(int i = 1; i<=7; i++){
			for(int j = 1; j<=7; j++){
				System.out.println("i: "+i+" j: "+j);
				System.out.println(index2xy(xy2index(i,j)));
			}
		}
	}
	static int xy2index(int i, int j){
		return 7 * (i - 1) + j;
	}

	static int index2xy(int index){
		int i = (index/7);
		int j = (index%7);
		if(j == 0)	j = 7;
		return 10*(((index-1)/7) + 1) + (index-1)%7+1;
	}
}

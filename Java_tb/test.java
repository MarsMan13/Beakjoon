import java.util.*;


class Main{


    public static void main(String[] args){

		LinkedList<Integer> list = new LinkedList<>();
    	
		for(int i = 0 ; i<5; i++){
			list.add(0, i);
		}
		System.out.println(list);
	}
}
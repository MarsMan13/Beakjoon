import java.util.*;


class Main{


    public static void main(String[] args){

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, 1);
		map.put(1, 2);
		map.put(1, 3);
		map.put(-1, 3);
		map.put(7, 3);
		map.put(9, 3);
		map.put(-1000, 3);
		System.out.println(map.get(1));
		System.out.println(map.firstKey());
	}
}
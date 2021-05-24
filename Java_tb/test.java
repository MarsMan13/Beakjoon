import java.util.*;


class Main{


    public static void main(String[] args){

		int[] bag1 = new int[]{7, 9, 11 , 13 , 15};
		int[] bag2 = new int[]{7, 9, 11 , 13 , 15};
		int[] bag3 = new int[]{7, 9, 11 , 13 , 15};
		
		System.out.println(binarySearch(bag1, 0, bag1.length-1, 10));
	}
	
	static int binarySearch(int[] ary, int left, int right, int size){
	
		if(size <= ary[left])
			return left;
		if(ary[right] < size)
			return -1;
		//
		int mid = (left + right) / 2;
		if(ary[mid] < size){
			return binarySearch(ary, mid+1, right, size);
		}
		else if(ary[mid] > size){
			return binarySearch(ary, left, mid, size);
		}
		return mid;
	}
}


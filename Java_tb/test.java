import java.util.*;
import java.io.*;


class Main{
	
	
	public static void main(String[] args) throws IOException {
		
		TreeSet<Long> set = new TreeSet<>();
		set.add(1L);
		System.out.println(set.ceiling(2L));
	}
}
class Main{

	public static void main(String[] args){
		long start = System.currentTimeMillis();

		int count = 0;
		for(int i = 0; i<2000000; i++){
			for(int j = 0; j<2000000; j++){
				count++;
			}
		}

		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}
}

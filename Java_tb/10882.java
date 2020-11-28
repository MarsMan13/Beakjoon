import java.util.*;



class Main{

	static double[] diff;
	static String[] results;

	static int h;
	static int m;
	
	static double dd;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		diff = new double[n+1];
		results = new String[n+1];
		sc.nextLine();

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");

		h = Integer.parseInt(st2.nextToken());
		m = Integer.parseInt(st2.nextToken());
		// h: 23
		// m: 00
		//

		diff[0] = Double.parseDouble(st.nextToken().substring(3));

		for(int i = 1; i<=n ; i++){
			diff[i] = Double.parseDouble(sc.nextLine().substring(3));
			//System.out.println(diff[i]+ " "+ diff[0]);
			results[i] = getResult(diff[i] - diff[0]);
		}

		for(int i = 1; i<=n; i++){
			System.out.println(results[i]);
		}

	}

	static String getResult(double diff){

		String ret = "";
		int hour = 0;
		int min = 0;
		int minor = 0;
		int tempH = 0;
		int tempM = 0;
		int carry = 0;

		if(diff >= 0){
			diff *= -1;
			minor = 1;
		}
		hour = (int)diff;
		min = (int)((diff - hour) * 60);

		//System.out.println("hour: "+hour+" min: "+min);

		if(minor == 0){
			tempM = m + min;
			carry = 0;
			if(tempM < 0){
				carry--;
				tempM += 60;
			}
			if(tempM >= 60){
				carry++;
				tempM -= 60;
			}

			tempH = h + hour + carry;
			if(tempH < 0){
				tempH+= 24;
			}
			if(tempH >= 24){
				tempH-=24;
			}
		
			//


		}
		else{
			tempM = m - min;
			carry = 0;
			if(tempM < 0){
				carry--;
				tempM += 60;
			}
			if(tempM >= 60){
				carry++;
				tempM -= 60;
			}
			tempH = h - hour + carry;

			if(tempH < 0){
				tempH+= 24;
			}
			if(tempH >= 24){
				tempH-=24;
			}
		}
		
		if(tempH < 10){
			ret += "0"+tempH;
		}
		else{
			ret += tempH;
		}
		
		if(tempM < 10){
			ret += ":0"+tempM;
		}
		else{
			ret += ":"+tempM;
		}

		return ret;
	}
}


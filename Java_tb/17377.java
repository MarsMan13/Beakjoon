import java.util.*;
import java.io.*;


class Main{

	static int A;	// 
	static int B;	// 1 cost
	static int C;	// 1 galler to mile
	static int N;

	static Place[] place;

	public static void main(String[] args) throws IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(bf.readLine());
		place = new Place[N];

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(bf.readLine());
			String placeName = getStrings(st, 2);
			place[i] = new Place(placeName, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(place);

		for(int i = 0; i<3; i++){
			st = new StringTokenizer(bf.readLine());
			String placeName = getStrings(st, 1);
	
			Place tempPlace = getPlace(placeName);
			tempPlace.type = 1;
			tempPlace.price = Integer.parseInt(st.nextToken());
		}

		//

	}

	static Place getPlace(String placeName){
		Place tempPlace = new Place(placeName, 0, 0);
		int index = Arrays.binarySearch(place, tempPlace);
		return place[index];
	}

	static String getStrings(StringTokenizer st, int minor){
		StringBuilder sb = new StringBuilder();
		int count = st.countTokens();
		for(int i = 1; i<=(count-minor); i++){
			sb.append(st.nextToken());
			sb.append(" ");
		}
		sb.setLength(sb.length() -1);
		return sb.toString();
	}
}

class Taxi{
	int money = 0;
	int guests = 0;
	double gas = 0.0;
	
	int x, y;

	Taxi(int x, int y, double gas){
		this.x = x;
		this.y = y;
		this.gas = gas;
	}

	public int command(String cmd){
		int head = 0;
		if(0<=cmd.indexOf("Go to")){
			head = 2;
		}
		else{
			head = 5;
			int temp = guestUp();
			if(temp != 0)
				return temp;
		}
		StringTokenizer st = new StringTokenizer(cmd);
		for(int i = 0; i<head; i++){
			st.nextToken();
		}

		switch(head){
			int temp;
			case 2:
				temp = goTo(st, 0);
				break;
			case 5:
				temp = goTo(st, 1);
				break;
		}
	
		return 0;
	}

	public int goTo(StringTokenizer st, int purpose){	//purpose: 	0 --> just go,
														//			1 --> for guest,
		Place tempPlace = Main.getPlace(Main.getStrings(st, 0));

		int distance = Math.abs(this.x - tempPlace.x) + Math.abs(this.y - tempPlace.y);
		double minorGallen = (distance + 0.0) / Main.C;
		int tempRet = minorGas(minorGallen);
		if(tempRet != 0){
			return tempRet;
		}

		if(purpose == 1){
			this.money += (Main.B * distance);
			this.guest -= 1;
		}

		if(tempPlace.type == 1){
			int needGas = (Main.A - this.gas);
			int needPrice = needGas * this.price;

			if(this.money < needPrice){
				
			}
			else{	// full up
				this.money -= needPrice;
			}
		}

		return 0;
	}

	public int minorGas(double value){
		this.gas -= value;
		if(this.gas < 0.0){	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			return 1;
		}
		return 0;
	}

	public int guestUp(){	// ERROR CODE : 2
		guests++;
		if(guests<4)
			return 0;
		return 2;
	}

}

class Place implements Comparable<Place>{

	String name;
	int x;
	int y;

	int type = 0;	//type = 1 ==> gas station
	int price = 0;

	Place(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString(){
		return this.name + " " + this.x + " "+ this.y;
	}

	@Override
	public int compareTo(Place obj){
		return this.name.compareTo(obj.name);
	}
}

import java.util.*;
import java.io.*;

class Main{
	
	static StringBuilder out = new StringBuilder();
	static List<Integer> resultValue = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 0; t<T; t++){
			int N = Integer.parseInt(bf.readLine());
			resultValue = new ArrayList<>();
			resultValue.add(1);
			def(N, 2);
			if(t != T-1)
				out.append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(out.toString());
		bf.close();
		bw.close();
	}

	// 0 : +
	// 1 : -
	// 2 : blank

	// 1 2-4
	// 12-4
	// 1+2+3 4
	
	public static void calc(){
		List<Integer> calcList = new ArrayList<>();
		calcList.add(1);
		for(int i = 1; i < resultValue.size(); i+=2){
			int curOpp = resultValue.get(i);
			int curValue = resultValue.get(i+1);
			if(curOpp == 2){
				int temp = calcList.remove(calcList.size() - 1);
				calcList.add(10 * temp + curValue);
			}
			else{
				calcList.add(curOpp);
				calcList.add(curValue);
			}
		}
		int result = calcList.get(0);
		for(int i = 1; i<calcList.size(); i+=2){
			if(calcList.get(i) == 0){		// +
				result += calcList.get(i+1);
			}
			else if(calcList.get(i) == 1){	// -
				result -= calcList.get(i+1);
			}
		}
		if(result == 0){
			for(int i = 0; i<resultValue.size(); i++){
				if(i % 2 == 0){	// 숫자자
					out.append(intToStr[resultValue.get(i)]);
				}
				else{			// 연산자
					switch(resultValue.get(i)){
						case 0:
							out.append("+");
							break;
						case 1:
							out.append("-");
							break;
						case 2:
							out.append(" ");
							break;
					}
				}
			}	
			out.append("\n");
		}
	}

	static String[] intToStr = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

	public static void def(int max, int cur){
		if(max < cur){
			calc();
			return;
		}
		int[] ops = new int[]{2, 0, 1};
		// for(int op = 0; op<3; op++){
		for(int op : ops){
			resultValue.add(op);
			resultValue.add(cur);
			def(max, cur+1);
			resultValue.remove(resultValue.size() - 1);
			resultValue.remove(resultValue.size() - 1);
		}
	}
}
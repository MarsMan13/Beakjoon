import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

	static int[] list = new int[10001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int temp;
		for(int i = 0; i<n; i++){
			temp = Integer.parseInt(br.readLine());
			list[temp]++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0; i<10001; i++){
			while(list[i] != 0){
				bw.write(i + "\n");
				list[i]--;
			}
		}
	
		br.close();
		bw.close();

	}
}

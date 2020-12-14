import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] input = null;
    static TreeMap<Integer, Integer> dp = new TreeMap<>();
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        // END OF INIT

        Arrays.sort(input);

        for(int i = 1; ; i++){
            if(!def1(i, Arrays.binarySearch(input, i)){
                System.out.println(i);
                break;
            }
        }
    }

    static boolean def1(int index, int n){

    }
}

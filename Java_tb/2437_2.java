import java.util.*;
import java.io.*;


class Main{

    static int N;
    static int[] input = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        if(input[0] != 1){
            System.out.println(1);
            return;
        }
        int left = 0;
        int right = 1;
        int end = right+1;
        for(int i = 1; i<N; i++){
            int temp = input[i];
            if(left + temp > right+1){
                System.out.println(end);
                return;
            }
            right += temp;
            end = right + 1;
        }

        System.out.println(end);
    }
}
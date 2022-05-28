import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static int[] input = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        // END OF INIT

        int min = 2147483647;
        int[] result = new int[2];

        outer:
        for(int i = 0; i<N; i++){
            int current = input[i];

            int left = 0;
            int right = N-1;
            int mid = 0;
            while(left <= right){
                mid = (left + right)/2;
                int temp = current + input[mid];
                // System.out.println("a: "+current+", b: "+input[mid]+" = "+temp);
                if(Math.abs(temp) < min && current != input[mid]){
                    min = Math.abs(temp);
                    result[0] = current;
                    result[1] = input[mid];
                }
                if(temp < 0){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        Arrays.sort(result);
        System.out.println(result[0]+" "+result[1]);
        return;
    }
}
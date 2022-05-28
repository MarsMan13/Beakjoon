import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] input = null;
    static HashMap<Integer, HashMap<Integer, Boolean>> dp = new HashMap<>();

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
            if(!def1(findBoundary(input, i), i)){
                System.out.println(i);
                break;
            }
        }
    }

    static boolean def1(int index, int n){
       
        if(dp.containsKey(index)){
            if(dp.get(index).containsKey(n)){
                return dp.get(index).get(n);
            }
        }
        else{
            dp.put(index, new HashMap<Integer, Boolean>());
        }

        if(n-input[index] == 0){
            dp.get(index).put(n, true);
            return true;
        }

        if(index == 0)
            return false;
        return def1(index-1, n) || def1(index-1, n-input[index]);

    }

    static int findBoundary(int[] input, int target){
        int left = 0;
        int right = input.length-1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(input[mid] < target){
                left = mid+1;
            }
            else if(target < input[mid]){
                right = mid-1;
            }
            else{
                return mid;
            }
        }
        return left;
    }

}

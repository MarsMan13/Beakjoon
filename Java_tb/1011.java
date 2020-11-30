import java.util.*;
import java.io.*;


class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        StringBuilder resultList = new StringBuilder();
        int x = 0;
        int y = 0;
        int diff = 0;
        
        for(int i = 0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            diff = y - x;

            long result = 0;
            long seed = 1;
            long rest = -1;
            while(true){
                if(!((seed * (seed+1)/2) <= (diff/2))){
                    seed--;
                    rest = diff - (seed * (seed+1));
                    break;
                }
                seed++;
            }
            result += (seed * 2);
            if((1 <= rest) && (rest <= seed+1)){
                result++;
            }
            else if((seed + 1 < rest) && (rest <= 2*seed + 1)){
                result+=2;
            }
            resultList.append(result);
            if(i != T-1){
                resultList.append("\n");
            }
        }
        System.out.println(resultList.toString());
     
    }
}
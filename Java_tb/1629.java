import java.util.*;
import java.io.*;


class Main{
    
    
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        
        // END OF INIT;
       
        System.out.println(my_pow(A, B, C));
        
    }
    
    public static long my_pow(long base, long up, long rest){
        if(up == 0){
            return 1;
        }
        if(up%2 == 0){
            long ret = my_pow(base, up/2, rest);
            return ret * ret % rest;
        }
        long ret = my_pow(base, (up-1)/2, rest);
        return ret * ret % rest * base % rest;
    }
} 
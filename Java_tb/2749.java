import java.util.*;
import java.io.*;


class Main{
    
    static TreeMap<Integer, Integer> dp = new TreeMap<>();
    static int rest = 1000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
      
        dp.put(1, 1);
        dp.put(2, 1);
        
        for(int i = 1; i<=1500000; i++){
            def1(i);
        }
         
        long rest2 = n%1500000;
        
        System.out.println(dp.get((int)rest2));
        
    }
    
    public static int def1(int v){
        if(!(dp.containsKey(v))){
            dp.put(v, (def1(v-1) + def1(v-2)) % rest);
        }
        return dp.get(v);
    }
}
import java.util.*;
import java.io.*;


class Main{
    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t<T; t++){
            String quadTree = bf.readLine();
        
            sb.append(def(quadTree, 0));    sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());    bw.flush(); bw.close();
    }
    
    public static StringBuilder def(String quadTree, int headIndex){
        if(quadTree.charAt(headIndex) != 'x'){
            return (new StringBuilder()).append(quadTree.charAt(headIndex));
        }
        // else
        int nextHead = headIndex+1;
        StringBuilder sb1 = def(quadTree, nextHead);
        nextHead += sb1.length();
        StringBuilder sb2 = def(quadTree, nextHead);
        nextHead += sb2.length();
        StringBuilder sb3 = def(quadTree, nextHead);
        nextHead += sb3.length();
        StringBuilder sb4 = def(quadTree, nextHead);
    
    
        sb1.append(sb2);
        sb4.append(sb1);
        sb3.append(sb4);
        return sb3.insert(0, 'x');
    }
}
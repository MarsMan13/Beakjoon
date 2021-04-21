import java.util.*;
import java.io.*;


class Main{
    
    static int R, C, M;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        Shark.sharks = new Shark[M+1];
        
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            Shark.addShark(i, new Shark(r, c, s, d, z));
        }
        // END OF INIT;
        
    }
}

class Shark{
    
    static Shark[] sharks = null;
    static int totSharkM = 0;
    int r, c;
    int s;
    int d;
    int z;
    
    int alive = 1;    // 1 --> alive, 0 --> dead
    
    Shark(int r, int c, int s, int d, int z){
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
    
    public static void addShark(int i, Shark newS){
        this.sharks[i] = newS;
    }
    
    public static void killSharks(int i){
        Shark temp = null;
        for(Shark s : sharks){
            if(temp.c == i){
                if(temp == null || (s.r < temp.c && s.alive == 1)){
                    tmep = s;
                }
            }
        }
        if(temp != null){
            temp.alive = 0;
            totSharkM += temp.z;
        }
    }
    
    public static void moveSharks(int i){
        
        for(Shark s : sharks){
            int steps = s.s;
            int bound = 0;
            
        }
    }
    
}










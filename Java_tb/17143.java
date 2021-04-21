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

class Shark implements Comparable<Shark>{
    
    static Shark[] sharks = null;
    static List<Position> pos = new ArrayList<Position>;
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
        sharks[i] = newS;
    }
    
    public static void catchShark(int i){
        Shark temp = null;
        for(Shark s : sharks){
            if(temp.c == i){
                if(temp == null || (s.r < temp.c && s.alive == 1)){
                    temp = s;
                }
            }
        }
        if(temp != null){
            temp.alive = 0;
            totSharkM += temp.z;
        }
    }
   
    
    static int[] ii = {0, -1, 1, 0, 0};
    static int[] jj = {0, 0, 0, 1, -1};
    
    public static void moveSharks(){
        
        for(Shark s : sharks){
            if(s.alive == 0)
                continue;
            
            int steps = s.s;
            int dir = s.d;
            int bound = 0;
            
            int new_r = s.r, new_c = s.c;
            if(1 <= new_r + steps * ii[dir] && new_r + steps * ii[dir] <= Main.R){
                new_r += steps * ii[dir];
            }
            else{
                int checker = ((steps + ii[dir] * new_r - Main.R * ((1-ii[dir])/2)) / Main.R) % 2;
                int rest = (steps * ii[dir] * new_r - Main.R * ((1-ii[dir])/2)) % Main.R;
                
                if(ii[dir] + checker == -1 || ii[dir] + checker == 2){
                    new_r = rest;
                }
                else{
                    new_r = Main.R - rest;
                }
            }
            
            if(1 <= new_c + steps * jj[dir] && new_c + steps * jj[dir] <= Main.C){
                new_c += steps * jj[dir];
            }
            else{
                int checker = (steps + jj[dir] * new_c - Main.C * ((1-jj[dir])/2) / Main.C) % 2;
                int rest = (steps + jj[dir] * new_c - Main.C * ((1-jj[dir])/2)) % Main.C;
                
                if(jj[dir] + checker == -1 || jj[dir] + checker == 2){
                    new_c = rest;
                }
                else{
                    new_c = Main.C - rest;
                }
            }
            // END OF CALC
            
            s.r = new_r; s.c = new_c;
        }
        
    }
    
    public static void eatSharks(){
        
    }
    
    
    @Override
    public int compareTo(Shark o){
        if(this.r != o.r){
            return this.r - o.r;
        }
        return this.c - o.c;
    }
}

class Position implements Comparable<Position>{
    int r, c;
    List<Shark> list = new ArrayList<>();
    
    Position(int r, int c){
        this.r = r;
        this.c = c;
    }
    
    public void addShark(Shark s){
        list.add(s);
    }
    
    public void killSharks(){
        if(list.empty()){
            return;
        }
        
        Shark temp = list.get(0);
        for(Shark s : list){
            if(temp.z < s.z){
                temp.alive = 0;
                temp = s;
            }
        }
    }
    
    
    @Override
    public int compareTo(Position o){
        if(this.r != o.r){
            return this.r - o.r;
        }
        return this.c - o.c;
    }
}









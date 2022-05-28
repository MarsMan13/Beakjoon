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
    
        Shark.sharks = new Shark[M];
        Shark.initPos1(R, C);
        
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            Shark.addShark(i, new Shark(r, c, s, d, z));
        }
        // END OF INIT;
     
        for(int j = 1; j<=C; j++){
            Shark.catchShark(j);
            Shark.moveSharks();
        }
        System.out.println(Shark.totSharkM);
    }
}

class Shark implements Comparable<Shark>{
    
    static ArrayList<Shark>[][] pos = null;
    
    static Shark[] sharks = null;
    static int totSharkM = 0;
    int r, c;
    int s;
    int d;
    int z;
    
    int alive = 1;    // 1 --> alive, 0 --> dead
  
    public static void initPos1(int R, int C){
        pos = new ArrayList[R+1][C+1];
    }
    
    public static void initPos2(int R, int C){
        for(int i = 1; i<=R; i++){
            for(int j = 1; j<=C; j++){
                pos[i][j]  = new ArrayList<Shark>();
            }
        }
    }
    
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
            if(s.c == i){
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
        
        initPos2(Main.R, Main.C);
        for(Shark s : sharks){
            if(s.alive == 0)
                continue;
            
            int steps = s.s;
            int dir = s.d;
            int bound = 0;
            
            int new_r = s.r, new_c = s.c;
            System.out.println("== Start ==");
            System.out.println("new_r : "+new_r);
            System.out.println("new_c : "+new_c);
            
            if(1 <= new_r + steps * ii[dir] && new_r + steps * ii[dir] <= Main.R){
                new_r += steps * ii[dir];
            }
            else{
                int flag1 = steps + ii[dir] * new_r;
                if(dir == 1){
                    flag1 += 1;
                }
                else if(dir == 2){
                    flag1 -= Main.R;
                }
                // System.out.println((steps + ii[dir] * new_r - Main.R * ((1+ii[dir])/2)));
                // int checker = ((steps + ii[dir] * new_r - Main.R * ((1+ii[dir])/2)) / Main.R) % 2;
                // int rest = (steps * ii[dir] * new_r - Main.R * ((1+ii[dir])/2)) % Main.R;
                int checker = flag1 / Main.R % 2;
                int rest = flag1 % Main.R;
                
                System.out.println("checker: "+checker);
                System.out.println("rest: "+rest);
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
                int checker = (steps + jj[dir] * new_c - Main.C * ((1+jj[dir])/2) / Main.C) % 2;
                int rest = (steps + jj[dir] * new_c - Main.C * ((1+jj[dir])/2)) % Main.C;
                
                if(jj[dir] + checker == -1 || jj[dir] + checker == 2){
                    new_c = rest;
                }
                else{
                    new_c = Main.C - rest;
                }
            }
            // END OF CALC
            
            System.out.println("new_r : "+new_r);
            System.out.println("new_c : "+new_c);
            s.r = new_r; s.c = new_c;
            pos[new_r][new_c].add(s);
        }
       
        eatSharks();
    }
    
    public static void eatSharks(){
       
        Shark temp = null;
        for(int i = 1; i<= Main.R; i++){
            for(int j = 1; j<=Main.C; j++){
                if(pos[i][j].size() == 0)
                    continue;
                for(Shark s : pos[i][j]){
                    if(temp == null || temp.z < s.z){
                        temp.alive = 0;
                        temp = s;
                    }
                }
            }
        }
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
    }
    
    
    @Override
    public int compareTo(Position o){
        if(this.r != o.r){
            return this.r - o.r;
        }
        return this.c - o.c;
    }
}









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
     
        int tot = 0;
        for(int j = 1; j<=C; j++){
            tot += Shark.catchShark(j);
            Shark.moveSharks();
            Shark.eatSharks();
        }
        System.out.println(tot);
    }
}

class Shark {
    
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
    
    public static int catchShark(int i){
        Shark temp = null;
        for(Shark s : sharks){
            if(s.c == i && s.alive == 1){
                if(temp == null || s.r < temp.r){
                    temp = s;
                }
            }
        }
        if(temp != null){
            temp.alive = 0;
            return temp.z;
        }
        return 0;
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
            
            int new_r = s.r, new_c = s.c;
            int new_d = s.d;
            
            
            if(dir == 1 || dir == 2){
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
                    int checker = flag1 / (Main.R - 1) % 2;
                    int rest = flag1 % (Main.R - 1);

                    if(ii[dir] + checker == -1 || ii[dir] + checker == 2){
                        new_r = rest+1;
                    }
                    else{
                        new_r = Main.R - rest;
                    }

                    if(new_d == 1){
                        if(checker == 0)
                            new_d = 2;
                        else
                            new_d = 1;
                    }
                    else if(new_d == 2){
                        if(checker == 0)
                            new_d = 1;
                        else
                            new_d = 2;
                    }
                }
            }
            else if(dir == 3 || dir == 4){
                if(1 <= new_c + steps * jj[dir] && new_c + steps * jj[dir] <= Main.C){
                    new_c += steps * jj[dir];
                }
                else{
                    int flag1 = steps + jj[dir] * new_c;
                    if(dir == 4){
                        flag1 += 1;
                    }
                    else if(dir == 3){
                        flag1 -= Main.C;
                    }
                    int checker = flag1 / (Main.C - 1) % 2;
                    int rest = flag1 % (Main.C - 1);

                    if(dir == 3 && checker == 1 || dir == 4 && checker == 0){
                        new_c = rest+1;
                    }
                    else{
                        new_c = Main.C - rest;
                    }

                    if(new_d == 3){
                        if(checker == 0)
                            new_d = 4;
                        else
                            new_d = 3;
                    }
                    else if(new_d == 4){
                        if(checker == 0)
                            new_d = 3;
                        else
                            new_d = 4;
                    }
                }
                
            }
            // END OF CALC
            s.r = new_r; s.c = new_c; s.d = new_d;
            pos[new_r][new_c].add(s);
        }
    }
    
    public static void eatSharks(){
       
        Shark temp = null;
        for(int i = 1; i<= Main.R; i++){
            for(int j = 1; j<=Main.C; j++){
                if(pos[i][j].size() == 0)
                    continue;
                temp = null;
                for(Shark s : pos[i][j]){
                    if(temp == null || temp.z < s.z){
                        temp = s;
                    }
                    s.alive = 0;
                }
                temp.alive = 1;
            }
        }
    }
}


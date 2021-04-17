import java.util.*;
import java.io.*;

class Main{
    
    static int N, M;
    static int[][] board = null;
    
    static int red_i = 0, red_j = 0;
    static int blue_i = 0, blue_j = 0;
    public static void main(String[] args) throws IOException {
    
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        
        
        for(int i = 0; i<N; i++){
            String tempInput = bf.readLine();
            for(int j = 0; j<M; j++){
                char temp = tempInput.charAt(j);
                
                if(temp == 'R'){
                    red_i = i; red_j = j;
                    temp = '.';
                }
                else if(temp == 'B'){
                    blue_i = i; blue_j = j;
                    temp = '.';
                }
               
                if(temp == '.'){
                    board[i][j] = 1;
                }
                else if(temp == 'O'){
                    board[i][j] = 2;
                }
            }
        }
        
        // END OF INPUT
       
        System.out.println(bfs());
        
    }
    
    public static int bfs(){
       
        int a = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(red_i, red_j, blue_i, blue_j, 0));
        while(!(queue.isEmpty())){
            Node tempNode = queue.poll();
            if(10 <= tempNode.count)
                continue;
            for(int i = 0; i<4; i++){
                Node newNode = new Node(tempNode.red_bead.i, tempNode.red_bead.j, 
                                    tempNode.blue_bead.i, tempNode.blue_bead.j, 
                                    tempNode.count+1);
                int ret = newNode.going(i);
                if(0 <= ret)
                    return ret;
                else if(ret != -1){
                    queue.offer(newNode);
                }
            }
        }
        return -1;
    }
}

class Node{
  
    Bead red_bead = null;
    Bead blue_bead = null;
    
    int count;
    
    Node(int i, int j, int ii, int jj, int count){
        this.red_bead = new Bead(i, j, 0);
        this.blue_bead = new Bead(ii, jj, 1);
        this.count = count;
    }
    
    static int[] ii = {1, -1, 0, 0};
    static int[] jj = {0, 0, 1, -1};
    static int[] reversor = {1, -1, 1, -1};
    
    public int going(int mode){
      
        int indexor = mode/2;
       
        Bead[] beads = new Bead[2];
        
        if(blue_bead.pos[indexor] * reversor[mode] < red_bead.pos[indexor] * reversor[mode]){
            beads[0] = red_bead;
            beads[1] = blue_bead;
        }
        else{
            beads[0] = blue_bead;
            beads[1] = red_bead;
        }    
        
        int ret = -2;
        for(int k = 0; k<2; k++){
            while(Main.board[beads[k].i + ii[mode]][beads[k].j + jj[mode]] != 0){
                if(k == 1 && ret < 0){
                    if(beads[k].i + ii[mode] == beads[0].i && beads[k].j + jj[mode] == beads[0].j){
                        break;
                    }
                }
                beads[k].i += ii[mode];
                beads[k].j += jj[mode];
    
                if(Main.board[beads[k].i][beads[k].j] == 2){
                    if(beads[k].colorFlag == 0 && ret != -1){
                        ret = this.count;
                    }
                    else if(beads[k].colorFlag == 1){
                        ret = -1;
                    }
                }
            } 
        }
        return ret;
    }
}

class Bead{
    
    int i, j;    // i <--> row, j <--> col
    int[] pos = new int[2];    // pos[0] <--> i, pos[1] <--> j
    int colorFlag;    // 0 --> red, 1 --> blue
    
    Bead(int i, int j, int color){
        this.i = i; this.j = j;
        this.pos[0] = i; this.pos[1] = j;
        this.colorFlag = color;
    }
   
    public String toString(){
        return "i: "+i+" , j: "+j;
    }
}


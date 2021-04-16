import java.util.*;
import java.io.*;


class Main{
    
    static int N, M;
    
    static int Rrow, Rcol;
    static int Brow, Bcol;
    
    static int[][] board = null;
    
    static int result = -1;
    
    public static void main(String[] args) throws IOException {

       
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
           
        board = new int[N][M];
        
        // END OF INIT
        
        for(int i = 0; i<N; i++){
            String row = bf.readLine();
            for(int j = 0; j<M; j++){
                char tempAt = row.charAt(j);
                board[i][j] = 1;            // road
                switch(tempAt){
                    case '#':    // 0
                        board[i][j] = 0;    // barrier
                        break;
                    case 'R':
                        Rrow = i; Rcol = j;
                        break;
                    case 'B':
                        Brow = i; Bcol = j;
                        break;
                    case 'O':
                        board[i][j] = 2;    // hole
                        break;
                }
            }
        }
       
        // END OF INIT
        bfs();
        
    }
    
    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(Rrow, Rcol, Brow, Bcol, 0));
        while(!(queue.isEmpty())){
            Node temp = queue.poll();
            for(int k = 0; k < 4; k++){
                int redCursor_i = temp.i; int redCursor_j = temp.j;
                int blueCursor_i = temp.ii; int blueCursor_j = temp.jj;
                
                Node newNode = new Node(temp.i, temp.j, temp.ii, temp.jj, temp.count+1);
               
                newNode.go(k);
            }
        }
    }
}

class Node{
    int count = 0;    //for step memory
    int from;
    
    Ball redBall = null;
    Ball blueBall = null;
    
    static int[] xx = {1, -1, 0, 0};
    static int[] yy = {0, 0, 1, -1};
    static int[] reversor = {1, -1, 1, -1}; 
    
    Node(int i, int j, int ii, int jj, int count){

        this.redBall = new Ball(i, j, 0);
        this.blueBall = new Ball(ii, jj, 1);
        this.count = count;
    }
    
    public int go(int mode){
        Ball firstBall = null;
        Ball secondBall = null;
        
        Ball[] balls = new Ball[2];
        
        int indexor = mode%2;    // 0,0,1,1
        if(redBall.pos[indexor] * reversor[mode] < blueBall.pos[indexor] * reversor[mode]){
            balls[0] = blueBall;
            balls[1] = redBall;
        }
        else{
            balls[0] = redBall;
            balls[1] = blueBall;
        }
        //END OF SET FIRST AND SECOND TARGET
     
        for(int i = 0; i<2; i++){
            Ball tempBall = balls[i];
            while(Main.board[tempBall.i+xx[mode]][tempBall.j+yy[mode]] != 0){
                if(i == 1){
                    if(tempBall.i+xx[mode] == balls[0].i && tempBall.j+yy[mode] == balls[0].j)
                        break;
                }
                tempBall.addX(xx[mode]);
                tempBall.addY(yy[mode]);
                
                if(board[tempBall.i][tempBall.j] == 2){
                    if(tempBall.colorFlag == 0){    //tempBall is red
                        return this.count;    
                    }
                }
            }
        }
        
        while(Main.board[firstBall.i+xx[mode]][firstBall.j+yy[mode]] != 0){
            firstBall.addX(xx[mode]);
            firstBall.addY(yy[mode]);
            if(Main.borad[firstBall.i])
        }
        while(Main.board[secondBall.i+xx[mode]][secondBall.j+yy[mode]] != 0 
              && secondBall.i+xx[mode] != firstBall.i 
              && secondBall.j+yy[mode] != firstBall.j){
            
            secondBall.addX(xx[mode]);
            secondBall.addY(yy[mode]);
        }
        
    }
    
    
    public String toString(){
        return "i: "+i+" j: "+j+", count: "+count;
    }
    
}

class Ball{
    int colorFlag = -1;    // 0 ==> red, 1 ==> blue
    int i, j;
    int[] pos = new int[2];
    
    Ball(int i, int j, int colorFlag){
        this.i = i;
        this.j = j;
        this.pos[0] = i;
        this.pos[1] = j;
        this.colorFlag = colorFlag;
    }
   
    public void setX(int v){
        i = v;
        pos[0] = v;
    }
    
    public void setY(int v){
        j = v;
        pos[1] = v;
    }
    
    public void addX(int v){
        i += v;
        pos[0] += v;
    }
    
    public void addY(int v){
        j += v;
        pos[1] += v;
    }
    
}














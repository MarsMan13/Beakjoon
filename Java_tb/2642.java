import java.util.*;
import java.io.*;



class Main{

    static int[][] input = new int[6+2][6+2];
    static int[][] visited = new int[6+2][6+2];
    static List<Planar> pls = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i<=6; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=6; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<=7; i++){
            visited[0][i] = 1;
            visited[i][0] = 1;
            visited[7][i] = 1;
            visited[i][7] = 1;
        }

        // END OF INIT
        for(int i = 1; i<=6; i++){
            for(int j = 1; j<=6; j++){
                if(visited[i][j] == 0 && input[i][j] != 0){
                    visited[i][j] = 1;
                    Planar temp = new Planar(i, j, input[i][j]);
                    pls.add(temp);
                    def1(i, j, temp.center);
                }
            }
        }

        // END OF PREPROCESSING

        if(pls.size() != 1){
            System.out.println(0);
            return;
        }
        Planar plan = pls.get(0);
        int result = def2(plan);

    }

    static int def2(Node node){
        
    }


    static void def1(int x, int y, Node node){

        System.out.println("x: "+x+" y: "+y);

        int[] xx = new int[]{0,0,1,-1};
        int[] yy = new int[]{1,-1,0,0};

        for(int i = 0; i<4; i++){
            if(visited[x+xx[i]][y+yy[i]] == 0 && input[x+xx[i]][y+yy[i]] != 0){
                visited[x+xx[i]][y+yy[i]] = 1;
                Node temp = new Node(x+xx[i], y+yy[i], node.no, input[x+xx[i]][y+yy[i]]);
                if(i == 0){
                    node.right = temp;
                }
                else if(i == 1){
                    node.left = temp;
                }
                else if(i == 2){   
                    node.up = temp;
                }
                else if(i == 3){
                    node.down = temp;
                }
                def1(x+xx[i], y+yy[i], temp);
            }
        }
    }
}

class Planar{

    static int no = 1;

    Node center = null;
    int count = 1;

    Planar(int x, int y, int index){
        center = new Node(x, y, no, index);
    }
}

class Node{
    int index = 0;
    int x, y;
    int no = 0;

    Planar pn = null;

    Node up = null;
    Node down = null;
    Node left = null;
    Node right = null;

    Node(int x, int y, int no, int index){
        this.x = x;
        this.y = y;
        this.no = no;
    }
}


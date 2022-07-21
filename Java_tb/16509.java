import java.util.*;
import java.io.*;


class Main{

    static int[] ii = new int[]{-3, -3, -2, 2, 3, 3, 2, -2};
    static int[] jj = new int[]{-2, 2, 3, 3, 2, -2, -3, -3};

    static int[] iii = new int[]{-1, -1, 0, 0, 1, 1, 0, 0};
    static int[] jjj = new int[]{0, 0, 1, 1, 0, 0, -1, -1};
    static int[] iiii = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] jjjj = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[][] visited = new int[10][9];
        Node sang = new Node(
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0
            );
        visited[sang.i][sang.j] = 1;
        st = new StringTokenizer(bf.readLine());
        Node king = new Node(
            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0
            );
        boolean flag = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(sang);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(king.i == cur.i && king.j == cur.j){
                System.out.println(cur.t);
                flag = true;
                break;
            }
            for(int s = 0; s<8; s++){
                int tempI = cur.i + ii[s];
                int tempJ = cur.j + jj[s];
                if(
                    !(cur.i + iii[s] == king.i && cur.j + jjj[s] == king.j) &&
                    !(cur.i + iiii[s] == king.i && cur.j + jjjj[s] == king.j)
                ){
                    if(0 <= tempI && tempI < 10 && 0 <= tempJ && tempJ < 9 && visited[tempI][tempJ] == 0){
                        visited[tempI][tempJ] = 1;
                        Node tempNode = new Node(tempI, tempJ, cur.t+1);
                        queue.offer(tempNode);
                    }
                }
            }
        }
        if(!flag){
            System.out.println(-1);
        }
    }
}

class Node{
    int i, j, t;
    Node(int i, int j, int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }

    @Override
    public String toString(){
        return ""+this.i+", "+this.j;
    }
}
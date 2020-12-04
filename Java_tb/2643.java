import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static List<Paper> input = new ArrayList<>();
    static int[][] dist = null;
    static Visited[][] visited = null;
    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dist = new int[N][N]; 
        visited = new Visited[N][N];
        
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            input.add(new Paper(
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                visited[i][j] = new Visited(i, j);
                if(i == j){
                    visited[i][j].addV(i); 
                    continue;   
                }
                Paper bottom = input.get(i);
                Paper up = input.get(j);
                if(bottom.can(up)){
                    visited[i][j].addV(i);
                    visited[i][j].addV(j);
                }
            }
        }
        
        // END OF INIT

        for(int k = 0; k<N; k++){
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(k == i || k == j || i == j)
                        continue;
                    Paper bottom = input.get(i);
                    Paper middle = input.get(k);
                    Paper up = input.get(j);
                    if(bottom.can(middle) && middle.can(up)){
                        visited[i][j].addV(visited[i][k].visited);      
                        visited[i][j].addV(visited[k][j].visited);      
                    }
                }
            }
        }


        int max = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(visited[i][j]+"  ");
                if(max < visited[i][j].visited.size()){
                    max = visited[i][j].visited.size();
                }
            }
            System.out.println();
        }
        System.out.println(max);
    }
}

class Visited{
    int i, j;
    List<Integer> visited = new ArrayList<Integer>();

    Visited(int i, int j){
        this.i = i;
        this.j = j;
    }

    void addV(int i){
        this.visited.add(i);
    }

    void addV(List<Integer> o){
        for(int i : o){
            int flag = 0;
            for(int j : this.visited){
                if(j == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                this.visited.add(i);
            }
        }
    }

    void showVisited(){
        System.out.print("from: "+i+" to: "+j+" == ");
        for(int i : this.visited){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    @Override
    public String toString(){
        return this.visited.size() + "";
    }
}

class Paper{
    int x, y;

    Paper(int x, int y){
        this.x = x;
        this.y = y;
    }

    boolean can(Paper o){ // Can "o" be on the "this"?
        if(o.x <= this.x && o.y <= this.y)
            return true;
        if(o.x <= this.y && o.y <= this.x)
            return true;
        return false;
    }
}
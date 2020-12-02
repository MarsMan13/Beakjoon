import java.util.*;
import java.io.*;


class Main{

    static int[][] input = new int[12][12];
    static List<Vertex> vertexes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i<=10; i++){
            String temp = bf.readLine();
            for(int j = 1; j<=10; j++){
                if(temp.charAt(j-1) == '0'){
                    input[i][j] = 0;
                }
                else{   // '1'
                    input[i][j] = 1;
                }
            }
        }

        // END OF INIT
        // FIND VERTEX
        for(int i = 1; i<=10; i++){
            for(int j = 1; j<=10; j++){
                if(input[i][j] == 1){
                    if(input[i-1][j] + input[i+1][j] + input[i][j-1] + input[i][j+1] == 1){
                        Vertex temp = new Vertex(i, j);
                        if(!vertexes.contains(temp)){
                            
                            vertexes.add(temp);
                        }
                    }
                }
            }
        }

        if(vertexes.size() != 3){
            System.out.println(0);
            return;
        }

        // Draw a Triangle

    }
}

class Vertex implements Comparable<Vertex>{

    int x;
    int y;
    int angle = 0;  // 1 --> right angle
    Vertex(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Vertex o){
        if(this.x != o.x)
            return this.x - o.x;
        return this.y - o.y;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Vertex))
            return false;
        Vertex o2 = (Vertex)o;
        if((this.x != o2.x) || (this.y != o2.y))
            return false;
        return true;
    }
    @Override
    public String toString(){
        return "i: "+this.x+", j: "+this.y;
    }
}

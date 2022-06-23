import java.util.*;
import java.io.*;


class Main{

    static int N, M;
    static List<Pair> houses = new ArrayList<>();
    static List<Pair> chickiens = new ArrayList<>();
    static int[][] dist = null;
    static int answer = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   M = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1)       houses.add(new Pair(i, j));
                else if(temp == 2)  chickiens.add(new Pair(i, j));
            }
        }
        dist = new int[chickiens.size()][houses.size()];
        for(int i = 0; i<chickiens.size(); i++){
            Pair chickien = chickiens.get(i);
            for(int j = 0; j<houses.size(); j++){
                Pair house = houses.get(j);
                dist[i][j] = 
                    (Math.abs(chickien.i - house.i))
                    + (Math.abs(chickien.j - house.j));
            }
        }
        def(0, 0, new int[M]);
        System.out.println(answer);
    }

    public static void def(int start, int depth, int[] selected){
        if(depth == M){
            int min = 0;
            for(int j = 0; j<houses.size(); j++){
                int tempMin = -1;
                for(int i : selected){
                    if(tempMin == -1 || dist[i][j] < tempMin){
                        tempMin = dist[i][j];
                    }
                }
                min += tempMin;
            }
            if(answer == -1 || min < answer)
                answer = min;
            return;
        }
        for(int i = start; i<=(chickiens.size() - (M - depth)); i++){
            selected[depth] = i;
            def(i+1, depth+1, selected);
        }        
    }
}

class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i; this.j = j;
    }
}
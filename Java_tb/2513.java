import java.util.*;
import java.io.*;


class Main{

    static int N, K, S;
    //The number of apartments, Limit of bus, The position of the school
    static List<Position> leftInput = new ArrayList<>();
    static List<Position> rightInput = new ArrayList<>();
    static int result = 0;
    
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Position.S = S = Integer.parseInt(st.nextToken());


        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            Position tempP = new Position(p, n);
            if(p < S)
                leftInput.add(tempP);
            else
                rightInput.add(tempP);
        }
        Collections.sort(leftInput);
        Collections.sort(rightInput);


        List<Position> input = leftInput;
        if(!input.isEmpty()){
            int left = K;
            int checker = 0;
            int homeFlag = 1;
            for(int i = 0; i<input.size();){
                Position target = input.get(i);
                if(homeFlag == 1){
                    checker = target.getDistance();
                    homeFlag = 0;
                }
              
                if(target.number < left){
                    left -= target.number;
                    target.number = 0;
                    i++;
                }
                else{
                    target.number -= left;
                    left = K;   //Go home
                    homeFlag = 1;   
                    result += checker * 2;
                    checker = 0;
                    if(target.number == 0){
                        i++;
                    }
                }
            }
            result += checker * 2;
        }
        input = rightInput;
        if(!input.isEmpty()){
            int left = K;
            int checker = 0;
            int homeFlag = 1;
            for(int i = 0; i<input.size();){
                Position target = input.get(i);
                if(homeFlag == 1){
                    checker = target.getDistance();
                    homeFlag = 0;
                }
              
                if(target.number < left){
                    left -= target.number;
                    target.number = 0;
                    i++;
                }
                else{
                    target.number -= left;
                    left = K;   //Go home
                    homeFlag = 1;   
                    result += checker * 2;
                    checker = 0;
                    if(target.number == 0){
                        i++;
                    }
                }
            }
            result += checker * 2;
        }
        System.out.println(result);
    }
}

class Position implements Comparable<Position>{

    static int S = 0;
    int position, number;

    Position(int p, int n){
        this.position = p;
        this.number = n;
    }

    int getDistance(){
        return Math.abs(S-this.position);
    }

    @Override
    public int compareTo(Position p){
        return Math.abs(S-p.position) - Math.abs(S-this.position);
    }

    @Override
    public String toString(){
        return this.position +" : "+this.number;
    }
}
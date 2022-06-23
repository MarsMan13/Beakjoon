import java.util.*;
import java.io.*;


class Main{


    static int N;
    static Dice[] dices = null;
    static int answer = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        dices = new Dice[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int[] inputs = new int[6];
            for(int j = 0; j<6; j++){
                inputs[j] = Integer.parseInt(st.nextToken());
            }
            dices[i] = new Dice(inputs);
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<2; j++){
                dices[0].joinPair = i;
                dices[0].upperPlane = j;
                def1(1);
            }
        }
        System.out.println(answer);
    }

    public static void def1(int index){
        if(index == N){
            int tot = 0;
            for(int i = 0; i<N; i++){
                tot += dices[i].getMaxPlane();
            }
            if(answer == -1 || answer < tot)
                answer = tot;
            return;
        }
        //
        for(int i = 0; i<3; i++){
            Dice beforeDice = dices[index-1];
            for(int j = 0; j<2; j++){
                if(beforeDice.pairs[beforeDice.joinPair].planes[beforeDice.upperPlane] == dices[index].pairs[i].planes[j]){
                    dices[index].joinPair = i;
                    dices[index].upperPlane = (j+1)%2;
                    def1(index+1);
                }
            }
        }
    }
}

class Dice{

    int joinPair = 0;
    int upperPlane = 0;

    Pair[] pairs = new Pair[3];
    Dice(int[] inputs){
        pairs[0] = new Pair(inputs[0], inputs[5]);
        pairs[1] = new Pair(inputs[1], inputs[3]);
        pairs[2] = new Pair(inputs[2], inputs[4]);
    }

    int getMaxPlane(){
        return Math.max(pairs[(joinPair + 1) % 3].getMaxPlane(), pairs[(joinPair + 2) % 3].getMaxPlane());
    }
}

class Pair{
    int[] planes = new int[2]; 
    Pair(int p1, int p2){
        planes[0] = p1;
        planes[1] = p2;
    }

    int getMaxPlane(){
        return Math.max(planes[0], planes[1]);
    }
}
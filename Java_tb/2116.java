import java.util.*;
import java.io.*;


class Main{

    static int N = 0;
    static Dice[] input = null;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        input = new Dice[N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            input[i] = new Dice(
                p(st.nextToken()), p(st.nextToken()), 
                p(st.nextToken()), p(st.nextToken()), 
                p(st.nextToken()), p(st.nextToken())
            );
        }

        // END OF INIT

        int max = -1;
        for(int i = 1; i<=6; i++){
            int[] tempSide = null;
            for(int[] f : input[0].fair){
                if(f[0] == i || f[1] == i){
                    tempSide = f;
                }
            }
            int tempMax = -1;
            for(int j = 1; j<=6; j++){
                if(j == tempSide[0] || j == tempSide[1])
                    continue;
                if(tempMax < j)
                    tempMax = j;
            }
            int temp = def1(1, i) + tempMax;
            if(max < temp)
                max = temp;
        }

        System.out.println(max);

    }

    static int def1(int n, int value){

        if(n == N)  return 0;
        Dice currentD = input[n];

        int newValue = -1;
        int max = 0;
        outer: 
        for(int[] f : currentD.fair){
            for(int i = 0; i<2; i++){
                if(f[i] == value){
                    newValue = f[(i+1)%2];
                    for(int j = 1; j<=6; j++){
                        if(j == value || j == newValue)
                            continue;
                        if(max < j)
                            max = j;
                    }
                    break outer;
                }
            }
        }
        return max + def1(n+1, newValue);
    }

    static int p(String s){
        return Integer.parseInt(s);
    }
}


class Dice{

    int[] side = new int[6];
    int[][] fair = null;
    int[] fair1 = new int[2];
    int[] fair2 = new int[2];
    int[] fair3 = new int[2];

    Dice(int a, int b, int c, int d, int e, int f){
        side[0] = a; side[1] = b; side[2] = c;
        side[3] = d; side[4] = e; side[5] = f;

        fair1[0] = a; fair1[1] = f;
        fair2[0] = b; fair2[1] = d;
        fair3[0] = c; fair3[1] = e;

        fair = new int[][]{fair1, fair2, fair3};
    }
}

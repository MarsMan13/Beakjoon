import java.util.*;
import java.io.*;


class Main{

    static int chuCount = 0;
    static int[] chu = null;
    static int chuSum = 0;

    static int targetCount = 0;
    static int[] target = null;
    static int currentTarget = 0;

    static int[][] dp = null;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        chuCount = Integer.parseInt(bf.readLine());
        chu = new int[chuCount];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<chuCount; i++){                                
            chu[i] = Integer.parseInt(st.nextToken());
            chuSum+=chu[i];
        }
        targetCount = Integer.parseInt(bf.readLine());
        target = new int[targetCount];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<targetCount; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        // END OF INIT

        for(int c = 0; c<targetCount; c++){
            currentTarget = target[c];
            dp = new int[2*(chuSum+currentTarget)+1][chuCount];
            for(int i = 0; i<2*(chuSum+currentTarget)+1; i++){
                for(int j = 0; j<chuCount; j++)
                    dp[i][j] = -1;
            }
           
            if(def1(currentTarget, 0, chuSum+currentTarget) == 1){
                System.out.print("Y ");
            }
            else{
                System.out.print("N ");
            }
        }
    }

    static int[] seed = new int[]{1, -1, 0};
    static int def1(int mass, int index, int mid){            
        if(mass == 0)
            return 1;
        for(int i = index; i<chuCount; i++){
            for(int j = 0; j<3; j++){
                int tempMass = mass + seed[j] * chu[i] + mid;
                if(dp[tempMass][i] == -1){                   
                    dp[tempMass][i] =  def1(tempMass-mid, i+1, mid);
                }
                if(dp[tempMass][i] == 1){
                    return 1;
                }
            }
        }
        return 0;
    }
}

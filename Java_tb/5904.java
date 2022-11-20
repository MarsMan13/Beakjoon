import java.util.*;

class Main{

    static int N;
    static int[] index2Length = new int[29];
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        index2Length[0] = 3;
        for(int i = 1; i<29; i++){
            index2Length[i] = index2Length[i-1] * 2 + i + 3;
        }
        // END OF INIT
        int start = N;
        int startIndex = 0;
        for(; index2Length[startIndex] <= start; startIndex++);
        
        while(true){
            if(start <= 3){
                System.out.println("moo".charAt(start-1));
                break;
            }
            int minorLength = index2Length[startIndex-1];
            if(start <= minorLength){
                ;
            }
            else if(start <= minorLength + startIndex + 3){
                if(start == minorLength + 1){
                    System.out.println("m");
                }
                else{
                    System.out.println("o");
                }
                break;
            }
            else{
                start -= (minorLength + startIndex+3);
            }
            startIndex--;
        }
    }
}
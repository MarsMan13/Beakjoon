import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        int[][] rowMap = new int[N+1][N+1];
        int[][] colMap = new int[N+1][N+1];
        int count = 0;  // result

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // END OF INIT

        for(int i = 1; i<=N; i++){
            int currentFloor = map[i][1];
            int lineFlag = 0;   // 0 => count up, 1 => not count
            for(int j = 1; j<=N && lineFlag != 1; j++){

                if(currentFloor == map[i][j])
                    continue;
                
                if(currentFloor - map[i][j] == 1){     // Down
                    if(j+L-1 > N){
                        lineFlag = 1;
                        break;
                    }
                    int tempJ = j-1;
                    for( ; j<=tempJ+L; j++){
                        if(rowMap[i][j] == 1){
                            lineFlag = 1;
                            break;
                        }
                        if(map[i][tempJ+1] != map[i][j]){
                            lineFlag = 1;
                            break;
                        }
                        rowMap[i][j] = 1;
                    }
                    j--;
                    currentFloor = map[i][j];
                }
                else if(currentFloor - map[i][j] == -1){ // Up
                    if(j-L <= 0){
                        lineFlag = 1;
                        break;
                    }
                    int tempJ = j;
                    for(j = j-1 ; tempJ-L <= j; j--){
                        if(rowMap[i][j] == 1){
                            lineFlag = 1;
                            break;
                        }
                        rowMap[i][j] = 1;
                        if(map[i][tempJ-1] != map[i][j]){
                            lineFlag = 1;
                            break;
                        }
                    }
                    j = tempJ;
                    currentFloor = map[i][j];
                }
                else{                                   // 2 <= Height
                    lineFlag = 1;
                    break;
                }
            }
            // END OF SECOND FOR-Statement
            if(lineFlag == 0){
                count++;
            }
        }

        //Repeat
        
        for(int i = 1; i<=N; i++){
            int currentFloor = map[1][i];
            int lineFlag = 0;   // 0 => count up, 1 => not count
            for(int j = 1; j<=N && lineFlag != 1; j++){

                if(currentFloor == map[j][i])
                    continue;
                
                if(currentFloor - map[j][i] == 1){     // Down
                    if(j+L-1 > N){
                        lineFlag = 1;
                        break;
                    }
                    int tempJ = j-1;
                    for( ; j<=tempJ+L; j++){
                        if(colMap[j][i] == 1){
                            lineFlag = 1;
                            break;
                        }
                        if(map[tempJ+1][i] != map[j][i]){
                            lineFlag = 1;
                            break;
                        }
                        colMap[j][i] = 1;
                    }
                    j--;
                    currentFloor = map[j][i];
                }
                else if(currentFloor - map[j][i] == -1){ // Up
                    
                    if(j-L <= 0){
                        lineFlag = 1;
                        break;
                    }
                    int tempJ = j;
                    for(j = j-1 ; tempJ-L <= j; j--){
                        if(colMap[j][i] == 1){
                            lineFlag = 1;
                            break;
                        }
                        colMap[j][i] = 1;
                        if(map[tempJ-1][i] != map[j][i]){
                            lineFlag = 1;
                            break;
                        }
                    }
                    j = tempJ;
                    currentFloor = map[j][i];
                }
                else{                                   // 2 <= Height
                    lineFlag = 1;
                    break;
                }
            }
            // END OF SECOND FOR-Statement
            if(lineFlag == 0){
                count++;
            }
        }

        //END OF PROC
        
        System.out.println(count);
    }
}
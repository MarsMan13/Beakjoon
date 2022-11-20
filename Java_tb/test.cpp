#include <stdio.h>
#include<string.h>
#include<stdlib.h>

#define MAX 2500


//회문판멸문 문자개수
int N;

int DP[MAX];
int FROM[MAX];

//주어진 문자열
// @@@@
char* String;

int P[MAX][MAX];


void Make_Palindrome()
{
    //우선 1개로 구성된 문자열은 회문
    for (int i = 1; i <= N; i++) {
        P[i][i] = 1;
    }

    //2개로 구성된 문자열은 둘이 같을 때 회문
    for (int i = 1; i < N; i++)
    {
        if (String[i-1] == String[i])
            P[i][i + 1] = 1;
    }

    //3개부터 그 이상의 경우
    for (int i = 3; i <= N; i++)
    {
        for (int Start = 1; Start + i - 1 <= N; Start++)
        {
            int End = Start + i - 1;

            //양쪽 끝지점이 같고 가운데 부분이 회문으로 판명난 경우 
            if (String[Start-1] == String[End-1] && P[Start+1][End - 1] == 1)
                P[Start][End] = 1;
        }
    }
}

void Solution()
{
    Make_Palindrome();

    for (int i = 0; i <= N; i++) {
        DP[i] = 0;
        FROM[i] = -1;
    }

    for (int End = 1; End <= N; End++)
    {
        DP[End] = 10000000;
        for (int Start = 1; Start <= End; Start++)
        {
            if (P[Start][End] == 1)
            {
                if(DP[Start-1] + 1 < DP[End]){
                    DP[End] = DP[Start-1] + 1;
                    FROM[End] = Start-1;
                }
            }
        }
    }
    int target = FROM[N];
    FROM[N] = -2;
    while(target != 0){
        int temp = target;
        target = FROM[target];
        FROM[temp] = -2;
    }
}



int main(void)
{
    int num;

    FILE* f1 = fopen("input.txt", "r");
    FILE* f2 = fopen("output.txt", "w");

    //num개수 만큼의 문제 문자열 투입
    fscanf(f1, "%d", &num);
    fprintf(f2, "%d\n", num);
    for (int i = 0; i < num; i++) {
        //N개의 숫자들
        fscanf(f1, "%d", &N);

        // @@@@ 
        String = (char*)malloc(sizeof(char) * (N+1));
        fscanf(f1, "%s", String);
        // @@@@ DO
        Solution();
        fprintf(f2, "%d\n", DP[N]);        
        int start = 1;
        for(int end = 1; end<=N; end++){
            if(FROM[end] == -2){
                for(int j = start-1; j<end; j++){
                    fprintf(f2, "%c", String[j]);
                }
                fprintf(f2, "\n");
                start = end+1;
            }
        }
    }

    free(String);

    fclose(f1);
    fclose(f2);

    return 0;
}
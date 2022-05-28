#include <stdio.h>
int NUM[101] ;
FILE *fin ;
int main(){
    int i, token,N ;
    int count=0, from= 0, value ;
    fin = fopen("X","r");
    fscanf(fin,"%d",&N);
    for(i=0; i<N; i++){
        fscanf(fin,"%d",&token);
        NUM[i]= token;
    } /* end of for */
    printf("%d\n", N ) ;
    value = NUM[ from ] ;
    while( count < N ) {
        while( value == 0 ) { 
            
            from = (from+1)%N; 
            value = NUM[ from ] ; 
        } /* end of inner while */
        printf("%d ", value ) ;
        count++ ;
        NUM[ from ] = 0 ; 
        from = (value +from )% N ; 
        value = NUM[ from ] ; 
    } /* end of outer while */
    return(0);
} /* end of main() */

int test(){

    int from = 0;
    int value = NUM[from];
    for(int count = from ; count < N; count++){

        
        
    }
}
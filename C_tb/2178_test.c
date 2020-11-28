#include <stdio.h>
#include <stdlib.h>

typedef struct {

	int level;
	int fathers_i;

	int *chilren;
	int children_n;

}nth_tree;


int main(void) {

	int i;

	while (getchar() == 1) {
		while (i != '\n') {
			scanf("%d", &i);
		}
	}
	

	return 0;
}
#include <stdio.h>
#include <stdlib.h>

int blocking(int **p, int n, int m);

int main(void) {

	int **p;
	int n, m;
	int i, j;

	p = (int **)calloc(n + 2, sizeof(int*));

	for (i = 0; i < n + 2; i++)
		p[i] = (int *)calloc(m + 2, sizeof(int));

	for (i = 1; i < n + 1; i++) {
		for (j = 1; j < m + 1; j++)
			scanf("%d", &p[i][j]);

	blocking(p, n, m);



	return 0;
}

int blocking(int **p, int n, int m) {

	int i, j;
	int count = 1;

	while (1) {
		count = 0;
		for (i = 1; i < n + 1; i++) {
			for (j = 1; j < m + 1; j++) {
				if ((i == 1 && j == 1) || (i == n && j == m)) continue;
				if (((p[i + 1][j] + p[i - 1][j] + p[i][j + 1] + p[i][j - 1]) == 1) && (p[i][j] == 1)) {
					p[i][j] = 0;
					count++;
				}
			}
		}
		if (count == 0) break;
	}
}
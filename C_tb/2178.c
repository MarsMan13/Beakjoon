#include <stdio.h>
#include <stdlib.h>
int def(int **p, int n, int m, int x, int y, int count, int dir);
void making(int **p, int **pp, int n, int m);
//int finding(int **p, int **pp, int n, int m);
int blocking(int **p, int n, int m);


int main(void) {

	int **p;
	int n, m;
	int i, j;

	scanf("%d %d", &n, &m);

	p = (int **)calloc(n+2, sizeof(int*));

	for (i = 0; i < n+2; i++)
		p[i] = (int *)calloc(m+2, sizeof(int));

	for (i = 1; i < n+1; i++) {
		for (j = 1; j < m+1; j++)
			scanf("%d", &p[i][j]);
	}
	//
	for (i = 0; i < n + 2; i++) {
		for (j = 0; j < m + 2; j++)
			printf("%d ", p[i][j]);
		printf("\n");
	}
	printf("\n");
	//

	blocking(p, n, m);
	printf("\nans : %d\n",def(p, n, m, 1, 1, 1, 3));
	//
	for (i = 0; i < n + 2; i++) {
		for (j = 0; j < m + 2; j++)
			printf("%d ", p[i][j]);
		printf("\n\n");
	}
	//


	return 0;
}

int def(int **p, int n, int m, int x, int y, int count, int dir) {
	
	int **pp;
	int i, j;
	int temp;
	
	if (x == m && y == n) {
		return count;
	}

	printf("%d %d\n", x, y);
	
	i = x, j = y;
	if (p[i][j + 1] == 1 && dir != 4) {
		temp = def(p, n, m, i, j + 1, count + 1, 2);
		printf("%d\n", temp);
		count = (temp > count) ? temp : count;
		if (temp >= n + m - 1) count = temp > count ? temp : count;
		else count = temp;
	}
	if ((p[i + 1][j]) == 1 && dir != 1) {
		temp = def(p, n, m, i + 1, j, count + 1, 3);
		printf("%d\n", temp);
		count = (temp > count) ? temp : count;
		if (temp >= n + m - 1) count = temp > count ? temp : count;
		else count = temp;
	}
	if ((p[i - 1][j]) == 1 && dir != 3) {
		temp = def(p, n, m, i - 1, j, count + 1, 1);
		printf("%d\n", temp);
		count = (temp > count) ? temp : count;
		if (temp >= n + m - 1) count = temp > count ? temp : count;
		else count = temp;
	}

	if (p[i][j - 1] == 1 && dir != 2) {
		temp = def(p, n, m, i, j- 1, count + 1, 4);
		printf("%d\n", temp);
		count = (temp > count) ? temp : count;
		if (temp >= n + m - 1) count = temp > count ? temp : count;
		else count = temp;
	}

	if (p[i][j + 1] == 1 && dir != 4) {
		temp = def(p, n, m, i, j+1, count + 1, 2);
		printf("%d\n", temp);
		count = (temp > count) ? temp : count;
		if (temp >= n + m - 1) count = temp > count ? temp : count;
		else count = temp;
	}

	return count;
}

void making(int **p, int **pp, int n, int m) {

	int i, j;

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++)
			pp[i][j] = p[i][j];
	}
}

/*
int finding(int **p, int **pp, int n, int m) {
	
	int i, j;

	i = 0, j = 0;
	while (1) {
		if (i == n && j == m) {
			//
		}
		else if((p[i + 1][j]%10 == 1) + (p[i - 1][j]%10 == 1) + (p[i][j + 1]%10 == 1) + (p[i][j - 1]%10 == 1) == 1) {
			p[i][j] = 0;
			pp[i][j] = 0;
		}
		else if((p[i + 1][j]%10 == 1) + (p[i - 1][j]%10 == 1) + (p[i][j + 1]%10 == 1) + (p[i][j - 1]%10) >= 3) {
			p[i][j] += 20;
		}
	}


}
*/

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

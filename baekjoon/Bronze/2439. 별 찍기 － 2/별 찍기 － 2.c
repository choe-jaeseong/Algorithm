#include <stdio.h>

int main(void) {
  int n, i, j, k;
  scanf("%d", &n);
  k = n;
  while (k > 0){
    i = 0;
    j = 0;
    while (i++ < k - 1)
      printf(" ");
    while (j++ < n - k + 1)
      printf("*");
    printf("\n");
    k--;
  }
  return 0;
}
#include <stdio.h>

int main(void) {
  int n, j;
  int i = 1;
  scanf("%d", &n);
  while (i <= n){
    j = 0;
    while (j < i){
      printf("*");
      j++;
    }
    printf("\n");
    i++;
  }
  return (0);
}
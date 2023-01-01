#include <stdio.h>

int main(void) {
  int N, x, y;
  scanf("%d %d", &N, &x);
  while (N > 0){
    scanf("%d", &y);
    if (y < x){
      printf("%d", y);
      if (N != 1)
        printf(" ");
    }
    N--;
  }
  return 0;
}
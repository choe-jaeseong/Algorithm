#include <stdio.h>

int main(void) {
  int Q, i = 6, j = 1;
  scanf("%d", &Q);
  if (Q == 1)
    printf("%d\n", 1);
  else {
    Q--;
    while (Q > 0)
      Q -= i * j++;
    printf("%d\n", j);
  }
  return 0;
}
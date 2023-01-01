#include <stdio.h>

int main(void) {
  int n, x, y, i;
  scanf("%d", &n);
  i = 0;
  while (i++ < n){
    scanf("%d %d", &x, &y);
    printf("Case #%d: %d + %d = %d\n", i, x, y, x + y);
  }
  return 0;
}
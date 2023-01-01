#include <stdio.h>

int main(void) {
  int n;
  int i = 1;
  scanf("%d", &n);
  while (i <= n)
    printf("%d\n", i++);
  return 0;
}
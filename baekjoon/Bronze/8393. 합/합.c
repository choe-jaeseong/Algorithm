#include <stdio.h>

int main(void) {
  int sum = 0;
  int n;
  scanf("%d", &n);
  while (n > 0)
    sum += n--;
  printf("%d\n", sum);
  return 0;
}
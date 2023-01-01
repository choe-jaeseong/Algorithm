#include <stdio.h>

int main(void) {
  int A, B, V, day = 0;
  scanf("%d %d %d", &A, &B, &V);
  day = (V - A) / (A - B);
  if ((V - A) > (A - B) * day)
    day += 2;
  else
    day++;
  printf("%d\n", day);
  return 0;
}
#include <stdio.h>

int main(void) {
  int  h, m;
  scanf("%d %d", &h, &m);
  if (m < 45){
    h -= 1;
    m = m + 60 - 45;
  }
  else
    m -= 45;
  if (h < 0)
    h += 24;
  printf("%d %d\n", h, m);
  return 0;
}
#include <stdio.h>

int main(void) {
  int  h, m, time;
  scanf("%d %d\n", &h, &m);
  scanf("%d\n", &time);
  m += time;
  if (m >= 60)
  {
    do{
      h++;
      m -= 60;
      if (h == 24)
        h = 0;
    } while (m >= 60);
  }
  printf("%d %d\n", h, m);
  return 0;
}
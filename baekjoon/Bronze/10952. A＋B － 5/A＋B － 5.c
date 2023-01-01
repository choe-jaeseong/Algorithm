#include <stdio.h>

int main(void) {
  int x, y;
  while (scanf("%d %d", &x, &y) != EOF){
    if (x == 0 && y == 0)
      break;
    printf("%d\n", x + y);
  }
  return 0;
}
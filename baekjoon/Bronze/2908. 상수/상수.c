#include <stdio.h>

int main(void) {
  char x[4], y[4], *max;
  scanf("%s %s", x, y);
  
  for (int i = 2; i >= 0; i--){
    if (x[i] > y[i]){
      max = x;
      break;
    }
    else if (x[i] < y[i]){
      max = y;
      break;
    }
  }
  for (int j = 2; j >= 0; j--)
    printf("%c", max[j]);
  printf("\n");
  
  return 0;
}
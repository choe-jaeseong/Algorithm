#include <stdio.h>

int main(void){
  int A, B, C;
  scanf("%d %d %d", &A, &B, &C);

  if ((C - B) <= 0){
    printf("%d\n", -1);
    return (0);
  }
  printf("%d\n", A / (C - B) + 1);

  return (0);
}
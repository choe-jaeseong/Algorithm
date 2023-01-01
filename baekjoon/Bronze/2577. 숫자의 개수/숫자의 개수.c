#include <stdio.h>

int main(void){
  int A, B, C;
  int arr[10] = {0};
  scanf("%d %d %d", &A, &B, &C);
  A = A * B * C;
  for (int i = 0; i < 10; i++){
    if (A == 0)
      break;
    arr[A % 10]++;
    A /= 10;
  }
  for (int i = 0; i < 10; i++)
    printf("%d\n", arr[i]);
  return (0);
}
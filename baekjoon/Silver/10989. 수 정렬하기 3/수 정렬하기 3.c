#include <stdio.h>

int main(void){
  int N, x, arr[10001] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++){
    scanf("%d", &x);
    arr[x]++;
  }
  for (int j = 0; j < 10001; j++){
    for (int k = 0; k < arr[j]; k++)
      printf("%d\n", j);
  }
  return (0);
}
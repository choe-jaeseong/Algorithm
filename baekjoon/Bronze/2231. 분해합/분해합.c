#include <stdio.h>

int main(void){
  int N, tmp, sum;
  scanf("%d", &N);
  for (int i = 1; i < N; i++){
    sum = i;
    tmp = i;
    do{
      sum += tmp % 10;
      tmp /= 10;
    } while (tmp);
    if (sum == N){
      printf("%d\n", i);
      return (0);
    }
  }
  printf("%d", 0);

  return (0);
}
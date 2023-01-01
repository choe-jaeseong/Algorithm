#include <stdio.h>

int is_primeNumber(int x){
  if (x == 1)
    return (0);
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0)
      return (0);
  return (1);
}

int main(void) {
  int M, N, flag = 0, sum = 0, min = 0;
  scanf("%d %d", &M, &N);
  for (int i = M; i <= N; i++){
    if (is_primeNumber(i)){
      if (flag == 0){
        min = i;
        flag = 1;
      }
      sum += i;
    }
  }
  if (sum == 0){
    printf("-1\n");
    return (0);
  }
  printf("%d\n%d\n", sum, min);
  return 0;
}
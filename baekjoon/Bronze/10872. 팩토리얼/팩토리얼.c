#include <stdio.h>

int recursive(int N){
  if (N == 0)
    return (1);
  return (N * recursive(N - 1));
}

int main(void) {
  int N;
  scanf("%d", &N);
  printf("%d\n", recursive(N));
  return 0;
}
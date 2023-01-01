#include <stdio.h>

int Fibonacci(int N){
  if (N == 0 || N == 1)
    return (N);
  return (Fibonacci(N - 1) + Fibonacci(N - 2));
}

int main(void) {
  int N;
  scanf("%d", &N);
  printf("%d\n", Fibonacci(N));
  return 0;
}
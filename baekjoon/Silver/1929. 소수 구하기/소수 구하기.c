#include <stdio.h>

int is_prime(int n){
  unsigned long long i = 2;
  if (n == 1) return (0);
  while (i * i <= (unsigned long long)n)
    if (n % i++ == 0)
      return (0);
  return (1);
}

int main(void){
  int M, N;
  scanf("%d %d", &M, &N);
  for (int i = M; i <= N; i++)
    if(is_prime(i))
      printf("%d\n", i);
  return (0);
}
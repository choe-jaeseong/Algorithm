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
  int N, x, cnt = 0;
  scanf("%d", &N);
  while (N--){
    scanf("%d", &x);
    if (is_primeNumber(x))
      cnt++;
  }
  printf("%d\n", cnt);
  return 0;
}
#include <stdio.h>

int main(void) {
  int N, i = 1;
  scanf("%d", &N);
  while (N > 0){
    if (N <= i)
      break;
    N -= i;
    i++;
  }  // i번째 집단 확인
  if (i % 2 == 1)
    printf("%d/%d\n" , i - (N - 1), N);
  else
    printf("%d/%d\n" , N, i - (N - 1));
  return 0;
}
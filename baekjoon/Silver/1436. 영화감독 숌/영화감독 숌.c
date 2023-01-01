#include <stdio.h>

int main(void){
  int N, tmp, i = 666, cnt = 1;
  scanf("%d", &N);
  while (cnt < N){
    tmp = i + 1;
    while (tmp){
      while (tmp != 0 && tmp % 10 != 6)
        tmp /= 10;
      if ((tmp / 10) % 10 == 6 && ((tmp / 10) / 10) % 10 == 6){
        cnt++; 
        tmp = 0;
      }
      else
        tmp /= 10;
    }
    i++;
  }
  printf("%d", i);
  return (0);
}
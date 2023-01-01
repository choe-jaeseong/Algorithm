#include <stdio.h>

int main(void) {
  int num, num2, cnt;
  scanf("%d", &num);
  cnt = 1;
  num2 = 10 * (num % 10) + (num/10 + num%10) % 10;
  while (num2 != num){
    num2 = 10 * (num2 % 10) + (num2/10 + num2%10) % 10;
    cnt++;
  }
  printf("%d\n", cnt);
  return 0;
}
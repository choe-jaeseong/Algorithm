#include <stdio.h>

int main(void){
  int  n, sum;
  char arr[100];
  scanf("%d", &n);
  sum = 0;
  scanf("%s", arr);
  for (int i = 0; i < n; i++){
    sum += arr[i] - '0';
  }
  printf("%d\n", sum);
  return (0);
}
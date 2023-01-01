#include <stdio.h>

int main(void) {
  char num1[10002] = {0}, num2[10002] = {0}, sum[10002] = {0}, tmp;
  int i = 0, j = 0, k = 0, a = 0;
  scanf("%s %s", num1, num2);
  while (num1[i]) i++;
  while (num2[j]) j++;
  if (i < j) k = j;
  else k = i;
  sum[k + 1] = 0; i--; j--;
  while (i >= 0 && j >= 0){
    tmp = sum[k] + num1[i] + num2[j] - '0';
    if (tmp > '9'){
      sum[k - 1]++;
      sum[k] = (tmp - '0') % 10 + '0';
    }
    else
      sum[k] = tmp;
    k--; i--; j--;
  }
  while (i >= 0) {
    sum[k] += num1[i--];
    if (sum[k] > '9'){
      sum[k - 1]++;
      sum[k] = (sum[k] - '0') % 10 + '0';
    }
    k--;
  }
  while (j >= 0) {
    sum[k] += num2[j--];
    if (sum[k] > '9'){
      sum[k - 1]++;
      sum[k] = (sum[k] - '0') % 10 + '0';
    }
    k--;
  }
  sum[k] += '0';
  while (sum[a] == '0')
    a++;
  while(sum[a]) 
    printf("%c", sum[a++]);
  printf("\n");
  return 0;
}
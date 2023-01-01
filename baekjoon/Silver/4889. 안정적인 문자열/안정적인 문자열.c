#include <stdio.h>

int main(void) {
  int i, sum, change = 0, cases = 1;
  char str[2000];
  while (1){
    scanf("%s", str);
    i = 0, sum = 0, change = 0;
    while (str[i]){
      if (str[i] == '-')
        return (0);
      if (str[i] == '{')
        sum++;
      else if (str[i] == '}')
        sum--;
      if (sum < 0){
        change++;
        sum += 2;
      }
      i++;
    }
    change += sum / 2;
    printf("%d. %d\n", cases++, change);
  }
  return 0;
}
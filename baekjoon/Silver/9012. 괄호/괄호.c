#include <stdio.h>

int main(void){
  char str[50];
  int cases, i, cnt, flag;
  scanf("%d", &cases);
  while (cases--){
    i = 0, cnt = 0, flag = 0;
    scanf("%s", str);
    
    while (str[i]){
      if (str[i] == '(')
        cnt++;
      else if (str[i] == ')')
        cnt--;
      if (cnt < 0){
        printf("NO\n");
        flag = 1;
        break;
      }
      i++;
    }
    if (flag == 1)
      continue;
    if (cnt != 0)
      printf("NO\n");
    else
      printf("YES\n");
  }
  return (0);
}
#include <stdio.h>

int main(void){
  int i, cnt;
  char str[1000000];
  scanf("%[^\n]s", str);

  cnt = 0;
  i = 0;
  while (str[i]){
    if ((str[i] != ' ' && str[i] != '\0') 
      && (str[i + 1] == ' ' || str[i + 1] == '\0'))
      cnt++;
    i++;
  }
  printf("%d\n", cnt);
  return (0);
}
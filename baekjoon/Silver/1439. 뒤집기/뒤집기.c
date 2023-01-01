#include <stdio.h>

int main(void){
  int cnt = 0;
  int i = 0;
  char str[1000000], std;
  scanf("%s", str);

  std = str[0];
  while (str[i]){
    if (str[i] == std){
      i++;
      continue;
    }
    else {
      while (str[i] && str[i] != std){
        i++;
      }
      cnt++;
    }
  }
  printf("%d\n", cnt);
  return (0);
}
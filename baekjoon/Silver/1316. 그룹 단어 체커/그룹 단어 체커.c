#include <stdio.h>

int is_groupWord(char *str){
  char used[26];
  int i = 1, j = 0;
  used[0] = str[0];
  
  while (str[i]){
    if (str[i] != used[j]){
      for (int k = j; k >= 0; k--)
        if (str[i] == used[k])
          return (0);
      used[++j] = str[i];
    }
    i++;
  }
  return (1);
}

int main(void){
  int cases, cnt = 0;
  char str[100];
  scanf("%d", &cases);

  while (cases--){
    scanf("%s", str);
    if (is_groupWord(str))
      cnt++;
  }
  printf("%d\n", cnt);
  return (0);
}
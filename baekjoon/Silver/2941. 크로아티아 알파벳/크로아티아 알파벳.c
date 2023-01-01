#include <stdio.h>

int main(void){
  int i = 0, cnt = 0;
  char str[100];
  scanf("%s", str);

  while (str[i]){
    if (str[i] == 'c' && (str[i + 1] == '=' || str[i + 1] == '-')){
      cnt++;
      i += 2;
      continue;
    }
    else if (str[i] == 'd'){
      if (str[i + 1] == 'z' && str[i + 2] == '='){
        cnt++;
        i += 3;
        continue;
      }
      else if (str[i + 1] == '-'){
        cnt++;
        i += 2;
        continue;
      }
    }
    else if (str[i] == 'l' && str[i + 1] == 'j'){
      cnt++;
      i += 2;
      continue;
    }
    else if (str[i] == 'n' && str[i + 1] == 'j'){
      cnt++;
      i += 2;
      continue;
    }
    else if (str[i] == 's' && str[i + 1] == '='){
      cnt++;
      i += 2;
      continue;
    }
    else if (str[i] == 'z' && str[i + 1] == '='){
      cnt++;
      i += 2;
      continue;
    }
    cnt++;
    i++;
  }
  printf("%d\n", cnt);
  return (0);
}
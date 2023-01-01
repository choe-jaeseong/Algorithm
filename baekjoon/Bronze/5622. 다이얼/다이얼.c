#include <stdio.h>

int main(void){
  int cnt = 0, i = 0;
  char str[16];
  scanf("%s", str);

  while (str[i]){
    if (str[i] >= 'P' && str[i] <= 'S'){
      cnt += 8;
      i++;
      continue;
    }
    else if (str[i] >= 'T' && str[i] <= 'V'){
      cnt += 9;
      i++;
      continue;
    }
    else if (str[i] >= 'W' && str[i] <= 'Z'){
      cnt += 10;
      i++;
      continue;
    }
    else{ 
      cnt += (str[i++] - 65) / 3 + 3; 
    }
  }
  printf("%d\n", cnt);
  
  return (0);
}
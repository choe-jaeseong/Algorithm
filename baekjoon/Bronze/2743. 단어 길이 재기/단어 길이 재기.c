#include <stdio.h>

void strlength(char *str){
  int i = 0;
  while (str[i])
    i++;
  printf("%d\n", i);
}

int main(void) {
  char str[101];
  scanf("%s", str);
  strlength(str);
  return 0;
}
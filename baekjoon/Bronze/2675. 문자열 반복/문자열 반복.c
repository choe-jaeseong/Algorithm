#include <stdio.h>

int main(void){
  int cases, repeat, j;
  char str[20];
  scanf("%d", &cases);
  while (cases--){
    scanf("%d %s", &repeat, str);
    j = 0;
    while (str[j]){
      for (int i = 0; i < repeat; i++)
        printf("%c", str[j]);
      j++;
    }
    printf("\n");
  }
  return (0);
}
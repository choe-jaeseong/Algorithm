#include <stdio.h>

int main(void){
  int cases, result, score;
  char arr[80];
  scanf("%d", &cases);
  while (cases-- > 0){
    result = 0;
    score = 0;
    scanf("%s", arr);
    int i = 0;
    while (arr[i]){
      if (arr[i++] == 'O'){
        score++;
        result += score;
      }
      else
        score = 0;
    }
    printf("%d\n", result);
  }
  return (0);
}
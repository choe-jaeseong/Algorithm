#include <stdio.h>

int main(void){
  int weight, cnt_5 = 0, cnt_3 = 0; 
  int quotient, remainder;
  scanf("%d", &weight);
  quotient = weight / 5;
  remainder = weight % 5;
  if (quotient == 0 && remainder == 4){
    printf("-1\n");
    return (0);
  }
  if (weight == 7){
    printf("-1\n");
    return (0);
  }
  if (remainder == 0)
    printf("%d\n", quotient);
  else if (remainder == 1)
    printf("%d\n", quotient + 1);
  else if (remainder == 2)
    printf("%d\n", quotient + 2);
  else if (remainder == 3)
    printf("%d\n", quotient + 1);
  else if (remainder == 4)
    printf("%d\n", quotient + 2);
  
  return (0);
}
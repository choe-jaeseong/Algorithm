#include <stdio.h>
#include <stdlib.h>

int arr_sum(int *arr, int num)
{
  int sum = 0;
  for (int i = 0; i < num; i++)
      sum += abs(arr[i]);
  return (sum);
}


int main(void) {
  int  num, i, sum = 0;
  int  arr[10000];
  
  scanf("%d", &num);
  for (int j = 0; j < 2; j++)
    {
      i = 0;
      while (i < num)
        scanf("%d", &arr[i++]);
      sum += arr_sum(arr, num);
    } 
  printf("%d", sum);

  return (0);
}
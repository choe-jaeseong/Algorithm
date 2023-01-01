#include <stdio.h>

int  arr_min(int *arr, int num){
  int i = 1;
  int min = arr[0];
  while (i < num){
    if (min > arr[i])
      min = arr[i];
    i++;
  }
  return (min);
}

int  arr_max(int *arr, int num){
  int i = 1;
  int max = arr[0];
  while (i < num){
    if (max < arr[i])
      max = arr[i];
    i++;
  }
  return (max);
}

int main(void) {
  int num;
  scanf("%d", &num);

  int arr[num], i, min, max;
  i = 0;
  while (i < num)
    scanf("%d", &arr[i++]);
  min = arr_min(arr, num);
  max = arr_max(arr, num);
  printf("%d %d\n", min, max);
  return 0;
}
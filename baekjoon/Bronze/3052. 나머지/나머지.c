#include <stdio.h>

int unique_count(int *arr){
  int tmp;
  int cnt = 1;
  for (int i = 0; i < 9; i++){
    for (int j = i + 1; j < 10; j++){
      if (arr[i] > arr[j]){
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
    }
  }
  tmp = arr[0];
  for (int k = 1; k < 10; k++){
    if (tmp != arr[k]){
      cnt++;
      tmp = arr[k];
    }
  }
  return (cnt);
}

int main(void){
  int arr[10];
  for (int i = 0; i < 10; i++)
    scanf("%d", &arr[i]);
  for (int i = 0; i < 10; i++)
    arr[i] %= 42;
  printf("%d\n", unique_count(arr));
  return (0);
}
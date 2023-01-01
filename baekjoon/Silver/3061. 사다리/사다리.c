#include <stdio.h>

int sort_count(int *arr, int lines){
  int tmp, cnt = 0;
  for (int i = 0; i < lines - 1; i++){
    for (int j = i + 1; j < lines; j++){
      if (arr[i] > arr[j]){
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        cnt++;
      }
    }
  }
  return (cnt);
}

int main(void){
  int cases, lines, arr[1000], minimum_rows;
  scanf("%d", &cases);
  while (cases--){
    scanf("%d", &lines);
    for (int i = 0; i < lines; i++)
      scanf("%d", &arr[i]);
    minimum_rows = sort_count(arr, lines);
    printf("%d\n", minimum_rows);
  }
  return (0);
}
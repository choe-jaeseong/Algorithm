#include <stdio.h>
#include <stdlib.h>

void binarySearch(int *arr, int size, int key){
  int left = 0, right = size - 1, mid;
  while (left <= right){
    mid = (left + right) / 2;
    if (arr[mid] < key) left = mid + 1;
    else if (arr[mid] > key) right = mid - 1;
    else {
      printf("1");
      return ;
    }
  }
  printf("0");
}

int compare(const void *a, const void *b){
  return *(int *)a - *(int *)b;
}

int main(void) {
  int N, M, group[500000] = {0}, card[500000] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++)
    scanf("%d", &group[i]);
  qsort(group, N, sizeof(int), compare);
  scanf("%d", &M);
  for (int j = 0; j < M; j++)
    scanf("%d", &card[j]);
  for (int k = 0; k < M; k++){
    binarySearch(group, N, card[k]);
    if (k != M - 1)
      printf(" ");
  }
  printf("\n");
  return 0;
}
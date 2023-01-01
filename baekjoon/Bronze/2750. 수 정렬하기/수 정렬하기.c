#include <stdio.h>

void merge(int *arr, int p, int q, int r){
  int i = p, j = q + 1, k = p;
  int data[100000];
  while (i<=q && j<=r){
    if (arr[i] < arr[j]) data[k++] = arr[i++];
    else data[k++] = arr[j++];
  }
  while (i <= q) data[k++] = arr[i++];
  while (j <= r) data[k++] = arr[j++];
  for (int a=p; a<=r; a++) arr[a] = data[a];
}

void merge_sort(int *arr, int p, int r){
  int q;
  if (p < r){
    q = (p + r) / 2;
    merge_sort(arr, p, q);
    merge_sort(arr, q+1, r);
    merge(arr, p, q, r);
  }
}

int main(void){
  int N, arr[1000] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++)
    scanf("%d", &arr[i]);
  merge_sort(arr, 0, N - 1);
  for (int j = 0; j < N; j++)
    printf("%d\n", arr[j]);
  return (0);
}
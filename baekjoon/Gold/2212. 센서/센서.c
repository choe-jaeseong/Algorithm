#include <stdio.h>

void merge(int arr[], int p, int q, int r){
  int i = p, j = q + 1, k = p;
  int tmp[10000];
  while (i<=q && j<=r){
    if (arr[i] < arr[j]) tmp[k++] = arr[i++];
    else tmp[k++] = arr[j++];
  }
  while (i<=q) tmp[k++] = arr[i++];
  while (j<=r) tmp[k++] = arr[j++];
  for (int a=p; a<=r; a++) arr[a] = tmp[a];
}

void mergeSort(int arr[], int p, int r){
  int q;
  if (p < r){
    q = (p + r)/2;
    mergeSort(arr, p, q);
    mergeSort(arr, q+1, r);
    merge(arr, p, q, r);
  }
}

int main(void){
  int N, K, result = 0, arr1[10000] = {0}, arr2[10000] = {0};
  scanf("%d %d", &N, &K);
  for (int i = 0; i < N; i++) scanf("%d", &arr1[i]);
  mergeSort(arr1, 0, N - 1);
  for (int j = 0; j < N - 1; j++) arr2[j] = arr1[j + 1] - arr1[j];
  mergeSort(arr2, 0, N - 2);
  for (int k = 0; k < N - K; k++) result = result + arr2[k];
  printf("%d\n", result);
  return (0);
}
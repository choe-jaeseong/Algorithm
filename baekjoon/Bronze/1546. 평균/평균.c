#include <stdio.h>

int find_max(float *arr, int N){
  int max = arr[0];
  for (int i = 1; i < N; i++){
    if (max < arr[i])
      max = arr[i];
  }
  return (max);
}

int main(void){
  float N, max, avg, arr[1000];
  scanf("%f", &N);
  for (int i = 0; i < N; i++)
    scanf("%f", &arr[i]);
  max = find_max(arr, N);
  for (int j = 0; j < N; j++)
    arr[j] = arr[j] / max * 100;
  avg = 0;
  for (int k = 0; k < N; k++)
    avg += arr[k] / N;
  printf("%f\n", avg);
  return (0);
}
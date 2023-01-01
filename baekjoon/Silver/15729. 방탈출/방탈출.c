#include <stdio.h>

int main(void) {
  int N, cnt = 0;
  int arr[1000000] = {0}, arr2[1000000] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++)
    scanf("%d", &arr[i]);
  for (int j = 0; j < N; j++){
    if (arr[j] != arr2[j]){
      cnt++;
      arr2[j] = 1 - arr2[j];
      arr2[j + 1] = 1 - arr2[j + 1];
      arr2[j + 2] = 1 - arr2[j + 2];
    }
  }
  printf("%d\n", cnt);
  return 0;
}
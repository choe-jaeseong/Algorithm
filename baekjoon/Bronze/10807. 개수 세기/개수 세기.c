#include <stdio.h>

int main(void) {
  int N, M, cnt = 0, arr[100] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++)
    scanf("%d", &arr[i]);
  scanf("%d", &M);
  for (int j = 0; j < N; j++)
    if (arr[j] == M)
      cnt++;
  printf("%d\n", cnt);
  return 0;
}
#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int A, B, N, i, key, cnt;
  scanf("%d %d", &A, &B);
  scanf("%d", &N);

  i = 0;
  int arr[N];
  while (i < N)
    scanf("%d", &arr[i++]);

  i = 0;
  cnt = 0;
  key = A;
  while (i < N){
    if (abs(key - B) > abs(B - arr[i])){
      key = arr[i];
      cnt = 1;
    }
    i++;
  }
  cnt += abs(B - key);
  printf("%d", cnt);
  return 0;
}
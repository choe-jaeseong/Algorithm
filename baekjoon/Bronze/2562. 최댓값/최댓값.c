#include <stdio.h>

int main(void) {
  int arr[9], i, j;
  i = 0;
  while (i < 9){
    scanf("%d", &arr[i]);
    i++;
  }
  i = 1;
  j = 0;
  while (i < 9){
    if (arr[j] < arr[i])
      j = i;
    i++;
  }
  printf("%d %d\n", arr[j], j + 1);
  return 0;
}
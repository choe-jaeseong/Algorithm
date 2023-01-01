#include <stdio.h>

int find_d(int i){
  int d = i + i % 10;
  while (i / 10){
    i /= 10;
    d += i % 10;
  }
  return (d);
}

int main(void){
  int d;
  int arr[10000] = {0};
  for (int i = 0; i < 10000; i++){
    d = find_d(i + 1);
    if (d <= 10000)
      arr[d - 1] = 1;
  }
  for (int j = 0; j < 10000; j++){
    if (arr[j] == 0)
      printf("%d\n", j + 1);
  }
  return (0);
}
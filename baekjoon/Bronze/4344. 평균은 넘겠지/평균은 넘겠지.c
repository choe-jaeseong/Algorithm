#include <stdio.h>

int main(void){
  int cases;
  float N, avg, cnt, arr[1000];
  scanf("%d", &cases);
  while (cases--){
    scanf("%f", &N);
    avg = 0;
    for (int i = 0; i < N; i++){
      scanf("%f", &arr[i]);
      avg += arr[i];
    }
    avg /= N;
    cnt = 0;
    for (int j = 0; j < N; j++)
      if (arr[j] > avg)
        cnt++;
    printf("%.3f%%\n", cnt / N * 100);
  }
  return (0);
}
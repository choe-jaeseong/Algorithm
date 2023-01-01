#include <stdio.h>

int main(void){
  int N, M, max = 0, card[1000000] = {0};
  scanf("%d %d", &N, &M);
  for (int i = 0; i < N; i++)
    scanf("%d", &card[i]);
  for (int a = 0; a < N - 2; a++){
    for (int b = a+1; b < N - 1; b++){
      for (int c = b+1; c < N; c++){
        if (card[a] + card[b] + card[c] > M)
          continue;
        else if (card[a] + card[b] + card[c] == M){
          printf("%d\n", M);
          return (0);
        }
        else if (card[a] + card[b] + card[c] > max)
          max = card[a] + card[b] + card[c];
      }
    }
  }
  printf("%d\n", max);
  return 0;
}
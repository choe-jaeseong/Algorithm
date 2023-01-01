#include <stdio.h>

int cnt_change(char str[][50], int a, int b){
  int cnt = 0, cnt_ops = 0;
  char start = str[a][b];
  for (int i = a; i < a + 8; i++){
    for (int j = b; j < b + 8; j++){
      if ((i - a) % 2 == 0 && (j - b) % 2 == 0){
        if (str[i][j] == start)
          cnt_ops++;
        else
          cnt++;
      } else if ((i - a) % 2 == 0 && (j - b) % 2 == 1){
        if (str[i][j] != start)
          cnt_ops++;
        else
          cnt++;
      }  else if ((i - a) % 2 == 1 && (j - b) % 2 == 0){
        if (str[i][j] != start)
          cnt_ops++;
        else
          cnt++;
      } else if ((i - a) % 2 == 1 && (j - b) % 2 == 1){
        if (str[i][j] == start)
          cnt_ops++;
        else
          cnt++;
      }
    }
  }
  if (cnt <= cnt_ops)
    return (cnt);
  else
    return (cnt_ops);
}

int main(void){
  int N, M, min, tmp;
  char str[50][50];
  scanf("%d %d", &N, &M);
  for (int i = 0; i < N; i++)
    scanf("%s", str[i]);
  for (int j = 0; j <= N - 8; j++){
    for (int k = 0; k <= M - 8; k++){
      tmp = cnt_change(str, j, k);
      if (j == 0 && k == 0)
        min = tmp;
      else if (min > tmp)
        min = tmp;
    }
  }
  printf("%d\n", min);
  
  return 0;
}
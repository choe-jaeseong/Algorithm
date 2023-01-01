#include <stdio.h>

void merge(int data[100000][2], int p, int q, int r){
  int i = p, k = p, j = q+1;
  int tmp[100000][2];
  while (i <= q && j <= r){
    if (data[i][1] < data[j][1]) {
      tmp[k][0] = data[i][0];
      tmp[k++][1] = data[i++][1];
    } else if (data[i][1] > data[j][1]) {
      tmp[k][0] = data[j][0];
      tmp[k++][1] = data[j++][1];
    } else {
      if (data[i][0] < data[j][0]) {
        tmp[k][0] = data[i][0];
        tmp[k++][1] = data[i++][1];
      } else {
        tmp[k][0] = data[j][0];
        tmp[k++][1] = data[j++][1];
      }
    }
  }
  while (i <= q) {
    tmp[k][0] = data[i][0];
    tmp[k++][1] = data[i++][1];
  }
  while (j <= r) {
    tmp[k][0] = data[j][0];
    tmp[k++][1] = data[j++][1];
  }
  for (int a = p; a <= r; a++) {
    data[a][0] = tmp[a][0];
    data[a][1] = tmp[a][1];
  }
}

void merge_sort(int data[100000][2], int p, int r){
  int q;
  if (p < r){
    q = (p + r) / 2;
    merge_sort(data, p, q);
    merge_sort(data, q+1, r);
    merge(data, p, q, r);
  }
}

int main(void) {
  int N, cdn[100000][2] = {0};
  scanf("%d", &N);
  for (int i = 0; i < N; i++)
    scanf("%d %d", &cdn[i][0], &cdn[i][1]);
  merge_sort(cdn, 0 , N - 1);
  for (int j = 0; j < N; j++)
    printf("%d %d\n", cdn[j][0], cdn[j][1]);
  return 0;
}
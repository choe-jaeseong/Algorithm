#include <stdio.h>
#include <string.h>

typedef struct Point2D{
  int d;
  int t;
} Point2D;

void merge(Point2D *data, int p, int q, int r) {
  int i = p, j = q + 1, k = p;
  Point2D tmp[1000000];
  while(i<=q && j<=r) {
    if (data[i].t <= data[j].t) tmp[k++] = data[i++];
    else tmp[k++] = data[j++];
  }
  while(i<=q) tmp[k++] = data[i++];
  while(j<=r) tmp[k++] = data[j++];
  for(int a = p; a<=r; a++) data[a] = tmp[a];
}

void mergeSort(Point2D *data, int p, int r){
  int q;
  if (p<r) {
    q = (p+r)/2;
    mergeSort(data, p, q);
    mergeSort(data, q+1, r);
    merge(data, p, q, r);
  }
}

int main(void){
  //과제 개수
  int cnt_subject = 0; 
  scanf("%d", &cnt_subject);

  //과제 정보
  Point2D p[cnt_subject];
  for (int i = 0; i < cnt_subject; i++)
    scanf("%d %d", &p[i].d, &p[i].t);
    
  //마감일에 따라 정렬
  mergeSort(p, 0, cnt_subject - 1);

  //최종 마감일로부터 걸리는 시간만큼 차감.
  int std = p[cnt_subject - 1].t;
  for (int k = cnt_subject - 1; k >= 0; k--){
    if (p[k].t < std) std = p[k].t;    // k의 마감일이 현재 기준점보다 작으면, 기준점은 k의 마감일.
    for (int j = 0; j < p[k].d; j++) std--;
  }
  printf("%d\n", std);
  return (0);
}
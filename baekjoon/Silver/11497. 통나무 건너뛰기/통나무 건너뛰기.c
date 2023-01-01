#include <stdio.h>

void print_small_diff(int *element, int size){
  int max = element[2] - element[0];
  for (int i = 1; i < size - 2; i++){
    if (max < element[i + 2] - element[i])
      max = element[i + 2] - element[i];
  }
  printf("%d\n", max);
}

void merge(int data[], int p, int q, int r) {
    int i = p, j = q+1, k = p;
    int tmp[10000]; // 새 배열
    while(i<=q && j<=r) {
        if(data[i] <= data[j]) tmp[k++] = data[i++];
        else tmp[k++] = data[j++];
    }
    while(i<=q) tmp[k++] = data[i++];
    while(j<=r) tmp[k++] = data[j++];
    for(int a = p; a<=r; a++) data[a] = tmp[a];
}

void mergeSort(int data[], int p, int r) {
    int q;
    if(p<r) {
        q = (p+r)/2;
        mergeSort(data, p , q);
        mergeSort(data, q+1, r);
        merge(data, p, q, r);
    }
}

int main(void) {
  int cases, size, element[10000], result;
  scanf("%d", &cases);
  while (cases--){
    scanf("%d", &size);
    for (int i = 0; i < size; i++)
      scanf("%d", &element[i]);
    mergeSort(element, 0, size - 1);
    print_small_diff(element, size);
  }
  return 0;
}
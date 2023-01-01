#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b){
	if (*(int *)a > *(int *)b)
		return 1;
	else if (*(int *)a < *(int *)b)
		return -1;
	else
		return 0;
}

int main(void){
  char str[11];
  int arr[11], length = 0;
  scanf("%s", str);
  for (int i = 0; str[i]; i++){
    arr[i] = str[i] - '0';
    length++;
  }
  qsort(arr, length, sizeof(int), compare);
  for (int j = length - 1; j >= 0; j--)
    printf("%d", arr[j]);
  printf("\n");
  return (0);
}
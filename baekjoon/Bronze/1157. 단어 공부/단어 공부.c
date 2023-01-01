#include <stdio.h>

char find_mod(int *arr){
  int i, max, max_index;
  max = arr[0];
  max_index = 0;
  i = 0;
  while (i < 25){
    if (arr[i + 1] > max){
      max = arr[i + 1];
      max_index = i + 1;
    }
    i++;
  }
  i = 0;
  while (i < 26){
    if (i == max_index){
      i++;
      continue;
    }
    if (arr[i] == max)
      return ('?');
    i++;
  }
  return ('A' + max_index);
}

int main(void){
  int arr[26] = {0};
  char str[1000000];
  scanf("%s", str);
  int i = 0;
  while (str[i]){
    for (int j = 0; j < 26; j++){
      if (str[i] == 'a' + j || str[i] == 'A' + j)
        arr[j] += 1;
    }
    i++;
  }
  printf("%c", find_mod(arr));
  
  return (0);
}
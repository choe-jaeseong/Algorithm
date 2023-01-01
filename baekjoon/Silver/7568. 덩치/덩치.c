#include <stdio.h>

int main(void){
  int person, rank, info[50][2] = {0};
  scanf("%d", &person);
  for (int i = 0; i < person; i++)
    scanf("%d %d", &info[i][0], &info[i][1]);
  for (int j = 0; j < person; j++){
    rank = 1;
    for (int k = 0; k < person; k++){
      if (info[j][0] < info[k][0] && info[j][1] < info[k][1])
        rank++;
    }
    printf("%d", rank);
    if (j != person - 1)
      printf(" ");
  }
  
  return (0);
}
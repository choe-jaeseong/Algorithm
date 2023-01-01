#include <stdio.h>
#include <stdlib.h>

typedef struct s_word{
  char w[51];
  int length;
} t_word;

int wordLen(char *word){
  int i = 0;
  while (word[i])
    i++;
  return (i);
}

int is_smaller(char *a, char *b){
  int i = 0;
  while (a[i]){
    if (a[i] > b[i])
      return (1);
    else if (a[i] < b[i])
      return (-1);
    i++;
  }
  return (0);
}

int compare(const void *p, const void *q){
  t_word *a = (t_word *)p;
  t_word *b = (t_word *)q;

  if (a->length > b->length)
    return (1);
  else if (a->length < b->length)
    return (-1);
  else
    return (is_smaller(a->w, b->w));
}

int main(void){
  int N;
  scanf("%d", &N);
  t_word dic[N];
  for (int i = 0; i < N; i++){
    scanf("%s", dic[i].w);
    dic[i].length = wordLen(dic[i].w);
  }
  qsort(dic, N, sizeof(t_word), compare);
  for (int j = 0; j < N; j++){
    if (j > 0 && compare(&dic[j - 1], &dic[j]) == 0)
      continue;
    printf("%s\n", dic[j].w);
  }
  return (0);
}
#include <stdio.h>
#include <stdlib.h>

typedef struct s_person{
  int age;
  int order;
  char name[101];
} t_person;

int compare(const void *a, const void *b){
  t_person *p = (t_person *)a;
  t_person *q = (t_person *)b;

  if (p->age > q->age)
    return (1);
  else if (p->age < q->age)
    return (-1);
  else if (p->order > q->order)
    return (1);
  else
    return (-1);
}

t_person person[100000];

int main(void) {
  int N;
  scanf("%d", &N);
  for (int i = 0; i < N; i++){
    scanf("%d %s", &person[i].age, person[i].name);
    person[i].order = i;
  }
  qsort(person, N, sizeof(t_person), compare);
  for (int j = 0; j < N; j++)
    printf("%d %s\n", person[j].age, person[j].name);
  return 0;
}
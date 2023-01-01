#include <stdio.h>

int find_people(int k, int n){
  int result = 0;
  if (k == 0)
    return (n);
  for (int i = 1; i <= n; i++)
    result += find_people(k - 1, i);

  return (result);
}

int main(void){
  int cases, k, n;
  scanf("%d", &cases);
  while (cases--){
    scanf("%d %d", &k, &n);
    printf("%d\n", find_people(k, n));
  }
  return (0);
}
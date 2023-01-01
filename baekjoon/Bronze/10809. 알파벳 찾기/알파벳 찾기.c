#include <stdio.h>

int ft_strlen(char *str){
  int i = 0;
  while (str[i])
    i++;
  return (i);
}

int print_index(char s, char *str){
  int i = 0;
  int len = ft_strlen(str);
  while (str[i]){
    if (str[i] == s)
      return (i);
    else
      i++;
  }
  if (i == len)
    return (-1);
}

int main(void) {
  char str[100];
  int i = 0;
  scanf("%s", str);
  for (char s = 'a'; s <= 'z'; s++){
    printf("%d", print_index(s, str));
    if (s != 'z')
      printf(" ");
  }
  return 0;
}
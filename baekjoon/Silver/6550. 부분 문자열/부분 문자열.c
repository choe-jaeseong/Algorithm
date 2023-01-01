#include <stdio.h>

int    strlen(char *s)
{
    int    i = 0;
    while (s[i])
        i++;
    return (i);
}

char    *is_in_str(char *s, char *t)
{
    int    i = 0;
    int    j = 0;
    int    len_s = strlen(s);
    int    len_t = strlen(t);
    
    while (s[i])
    {
        while (t[j])
        {
            if (s[i] == t[j])
            {
                i++;
                j++;
                if (i == len_s)
                    return ("Yes");
            }
            else
            {
                j++;
                if (j == len_t)
                    return ("No");
            }
        }
        i++;
    }
  return ("No");
}

int main(void)
{
  char s[100000];
  char t[100000];

  while (scanf("%s %s", s, t) != EOF)
  {
      printf("%s\n", is_in_str(s, t));
  }
  return(0);
}
#include <stdio.h>

int  is_duplicate(int *dice)
{
  int i = 0;
  if (dice[0] == dice[1])
    i++;
  if (dice[0] == dice[2])
    i++;
  if (dice[1] == dice[2])
    i++;
  return (i);
}

int  select_dice(int *dice){
  int  i = dice[0];
  if (is_duplicate(dice) == 1){
    if (dice[1] == dice[2])
      i = dice[1];
  }
  else {
    if (i < dice[1])
      i = dice[1];
    if (i < dice[2])
      i = dice[2];
  }
  return (i);
}

int main(void) {
  int  dice[3], reward;
  for (int i = 0; i < 3; i++){
    scanf("%d", &dice[i]);
  }
  if (is_duplicate(dice) == 3)
    reward = 10000 + dice[0] * 1000;
  else if (is_duplicate(dice) == 1)
    reward = 1000 + select_dice(dice) * 100;
  else
    reward = select_dice(dice) * 100;
  printf("%d\n", reward);
  
  return 0;
}
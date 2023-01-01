#include <stdio.h>

int main(void){
  int cases, H, W, guest_number;
  int cnt_x, cnt_y;
  scanf("%d", &cases);
  while (cases--){
    cnt_x = 1, cnt_y = 0;
    scanf("%d %d %d", &H, &W, &guest_number);
    while (guest_number > H){
      guest_number -= H;
      cnt_x++;
    }
    cnt_y += guest_number;
    printf("%d", cnt_y);
    if (cnt_x < 10)
      printf("0");
    printf("%d\n", cnt_x);
  }
  return (0);
}
#include <stdio.h>

int data[1000000] = {0, };
long long pos = 0;

void push(int x){
  data[pos++] = x;
}

void pop(){
  pos--;
}

int main(void) {
  int N, num;
  long long cnt = 0;
  scanf("%d", &N);
  while(N--){
    scanf("%d", &num);
    while (pos > 0 && num >= data[pos - 1])
      pop();
    push(num);
    cnt = cnt + pos - 1;
  }
  printf("%lld\n", cnt);
  return 0;
}
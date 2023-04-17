package 고득점kit.Stack_Queue.주식가격;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Stock{
    int idx;
    int price;
    int time = 0;
    Stock(int idx, int price){
        this.idx = idx;
        this.price = price;
    }
    public void passing(){
        time++;
    }
}
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Stock> Q = new LinkedList<>();
        Stack<Stock> S = new Stack<>();
        
        for(int i=0; i<prices.length; i++)      //주식 값 입력
            Q.offer(new Stock(i, prices[i]));
        while(!Q.isEmpty()){
            Stock tmp = Q.poll();
            if(tmp.idx==answer.length-1){
                tmp=null;
                break;
            }
            if(S.isEmpty()){
                S.push(tmp);
                tmp=null;
            } else if (S.peek().price<=tmp.price){
                S.push(tmp);
                tmp=null;
            } else {
                while(!S.isEmpty() && S.peek().price>tmp.price){
                    Stock tmp2 = S.pop();
                    answer[tmp2.idx]=tmp2.time;
                    tmp2=null;
                }
                S.push(tmp);
            }
            for(Stock x : S) x.passing();
        }
        while(!S.isEmpty()){
            Stock tmp = S.pop();
            answer[tmp.idx]=tmp.time;
            tmp=null;
        }
        answer[answer.length-1]=0;
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,2,3,2,3};
        for(int x : T.solution(arr))
            System.out.print(x+" ");
    }
}

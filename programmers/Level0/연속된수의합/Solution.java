package Level0.연속된수의합;

public class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for(int i=1000; i>-100; i--){
            int sum = 0;
            for(int j=i; j>i-num; j--) sum+=j;
            if(sum==total){
                for(int k=num-1; k>=0; k--){
                    answer[k] = i--;
                }
                break;
            }
        }

        return answer;
    }

    //다른 풀이1
    public int[] solution1(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
                answer[i] = start + i ;
        }
        return answer;
    }
}

package Level1.푸드파이트대회;

public class Solution {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                sb1.append(i);
            }
        }
        String answer = sb1.toString() + "0" + sb1.reverse().toString();
        return answer;
    }

    //다른 풀이1
    public String solution1(int[] food) {
        String answer = "0";
        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i; 
            }
        }
        return answer;
    }
    //다른 풀이2
    public String solution2(int[] food) {
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            int result = food[i] / 2;
            builder.append(String.valueOf(i).repeat(result));
        }
        String answer = builder + "0";
        return answer + builder.reverse();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,1,3,5};
        System.out.println(T.solution(arr));
    }
}

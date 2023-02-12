package Level0.잘라서배열로저장하기;

public class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length()%n==0? my_str.length()/n: my_str.length()/n+1];
        for(int i=0; i<answer.length; i++){
            answer[i] = i*n+n < my_str.length()? my_str.substring(i*n, i*n+n): my_str.substring(i*n, my_str.length());
        }
        return answer;
    }

    //다른 풀이1
    public String[] solution1(String my_str, int n) {
        int resultCnt = (my_str.length() + n - 1) / n;
        String[] answer = new String[resultCnt];

        for (int i = 0; i < resultCnt; i++) {
            int start = n * i;
            int end = start + n >= my_str.length()? my_str.length(): start + n;
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        for(String x : T.solution("1234567890", 3)){
            System.out.println(x);
        }
    }
}

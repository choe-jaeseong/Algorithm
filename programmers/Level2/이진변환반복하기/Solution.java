package Level2.이진변환반복하기;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];  //[0]: 변환횟수, [1]: 제거한 0의 갯수
        while(!s.equals("1")){
            answer[0]++;
            String a = s.replace("0", "");
            answer[1]+=s.length()-a.length();
            s = Integer.toBinaryString(a.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        for(int x : T.solution("110010101001"))
            System.out.println(x);
    }
}

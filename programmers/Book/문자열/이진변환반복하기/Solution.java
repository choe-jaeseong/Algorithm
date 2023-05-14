package 문자열.이진변환반복하기;

public class Solution {
    private int countZeros(String s){
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c=='0') zeros++;
        }
        return zeros;
    }
    public int[] solution(String s){
        int loop = 0;
        int removed = 0;
        
        while(!s.equals("1")){
            int zeros = countZeros(s);
            loop += 1;
            removed += zeros;
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
        }

        return new int[]{loop, removed};
    }

    //예전 나의 풀이

    // public int[] solution(String s) {
    //     int[] answer = new int[2];  //[0]: 변환횟수, [1]: 제거한 0의 갯수
    //     while(!s.equals("1")){
    //         answer[0]++;
    //         String a = s.replace("0", "");
    //         answer[1]+=s.length()-a.length();
    //         s = Integer.toBinaryString(a.length());
    //     }
    //     return answer;
    // }
}

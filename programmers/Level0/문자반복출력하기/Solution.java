package 문자반복출력하기;

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for(char x : my_string.toCharArray()){
            for(int i=0; i<n; i++) answer += x;
        }
        return answer;
    }

    //다른 사람 풀이1
    public String solution1(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()){
            sb.append((c + "").repeat(n));
        }
        return sb.toString();
    }

    //다른 사람 풀이2
    public String solution2(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            answer += str[i].repeat(n);
        }
        return answer;
    }
}

package Level0.숨어있는숫자의덧셈2;


public class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String tmp = "";
        for(char x : my_string.toCharArray()){
            if(Character.isDigit(x)) tmp+=x;
            else if(!tmp.equals("")){
                answer += Integer.parseInt(tmp);
                tmp = "";
            }
        }
        if(!tmp.equals("")) answer += Integer.parseInt(tmp);
        return answer;
    }

    //다른 풀이1
    public int solution1(String my_string) {
        int answer = 0;

        String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

        for(String s : str){
            if(!s.equals("")) answer += Integer.valueOf(s);
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(""));
    }
}

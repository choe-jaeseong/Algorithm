package Level0.OX퀴즈;

public class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String x : quiz){
            int result = 0;
            int sign = 1;
            boolean flag = false;
            for(String y : x.split(" ")){
                if(y.equals("=")){
                    flag = true;
                } else if(y.equals("+")){
                    sign = 1;
                } else if(y.equals("-")){
                    sign = -1;
                } else if(!flag){
                    result += sign * Integer.parseInt(y);
                } else {
                    if(result==Integer.parseInt(y)) answer[i] = "O";
                    else answer[i] = "X";
                    i++;
                }
            }
        }
        return answer;
    }
}

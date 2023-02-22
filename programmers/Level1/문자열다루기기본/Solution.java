package Level1.문자열다루기기본;

public class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if(len==4 || len==6){
            for(char x : s.toCharArray()){
                if(!Character.isDigit(x))
                    return false;
            }
            return true;
        }
        return false;
    }

    //다른 풀이1 (예외 사용은 안좋은 풀이!)
    public boolean solution1(String s) {
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;
    }
    //다른 풀이2
    public boolean solution2(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }
    //다른 풀이3
    public boolean solution3(String s) {
        return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
    }
}

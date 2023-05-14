package 문자열.문자열다루기기본;

public class Solution {

    //풀이1 - 정규표현식
    public boolean solution1(String s){
        return s.matches("[0-9]{4}|[0-9]{6}");
    }

    //풀이2 - 기본편
    public boolean solution2(String s){
        if(!(s.length()==4 || s.length()==6)) return false;

        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)) return false;
        }
        
        return true;
    }
}

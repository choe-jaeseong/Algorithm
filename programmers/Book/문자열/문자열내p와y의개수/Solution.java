package 문자열.문자열내p와y의개수;

public class Solution {

    //강의 답
    public boolean solution1(String s){
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        return ps==ys;
    }

    //강의 답 : 효율적인 버전
    public boolean solution2(String s){
        int ps = 0;
        int ys = 0;

        for(char c : s.toCharArray()){
            switch(c){
                case 'p', 'P' -> ps++;
                case 'y', 'Y' -> ys++;
            }
        }
        return ps==ys;
    }

    //나의 답
    public boolean solution(String s){
        String toLower = s.toLowerCase();
        String p = toLower.replaceAll("[^p]", "");
        String y = toLower.replaceAll("[^y]", "");
        return p.length()==y.length() ? true : false;
    }
}

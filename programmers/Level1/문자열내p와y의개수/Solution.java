package Level1.문자열내p와y의개수;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        return answer;
    }

    //다른 풀이1
    boolean solution1(String s) {
        s = s.toUpperCase();
        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
    //다른 풀이2 (정규식)
    boolean solution2(String s) {
        return s.replaceAll("[^yY]", "").length() - s.replaceAll("[^pP]", "").length() == 0 ? true : false;
    }
    //다른 풀이3
    boolean solution3(String s) {
        int size = s.length(), pCount = 0, yCount = 0;
        for(int i=0; i<size; i++){
            switch(String.valueOf(s.charAt(i)).toUpperCase()){
                case "P": pCount++; break;
                case "Y": yCount++; break;
                default: break;
            }
        }
        if(pCount==0 && yCount==0) return true;
        return (pCount==yCount)?true:false;
    }
}

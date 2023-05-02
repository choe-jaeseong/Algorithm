package Book.문자열.이상한문자만들기;

public class Solution {

    //답안
    public String solution(String s){
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){ //Character.isSpaceChar
                builder.append(c);
                toUpper = true;
            } else {
                if(toUpper){
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return builder.toString();
    }

    //나의 답 (spllit 활용)
    // public String change(String x){
    //     StringBuilder builder = new StringBuilder();
    //     x = x.toLowerCase();
    //     i
    //     return builder.toString();
    // }
    // public String solution(String s){
    //     String[] words = s.split(" ");
    //     for(String x : words){
    //         x = change(x);

    //     }
    // }
}

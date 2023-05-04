package 문자열정렬하기1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(String my_string) {
        String answer = my_string.replaceAll("[A-Z]","").replaceAll("[a-z]","");
        int[] ans = new int[answer.length()];
        for(int i=0; i<answer.length(); i++){
            ans[i] = answer.charAt(i)-48;
        }
        Arrays.sort(ans);
        return ans;
    }

    //다른 풀이1
    public int[] solution1(String myString) {
        return Arrays.stream(myString.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
    }
    //다른 풀이2
    public int[] solution2(String my_string) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++) {
            char characterData = my_string.charAt(i);

            if (Character.isDigit(characterData)) {
                String stringData = String.valueOf(characterData);
                list.add(stringData);
            }
        }
        return list.stream().sorted().mapToInt(Integer::parseInt).toArray();
    }
    //다른 풀이3
    public int[] solution3(String my_string) {
        String[] strArr = my_string.replaceAll("[a-zA-Z]","").split("");
        Arrays.sort(strArr);

        return Arrays.stream(strArr).mapToInt(e -> Integer.parseInt(e)).toArray();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "a1x5c2v4v3";
        for(int x : T.solution(str)) System.out.println(x);
    }
}

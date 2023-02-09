package Level0.모스부호1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String letter){
        Map<String, String> map = new HashMap<>() {
            {
                put(".-", "a");
                put("-...", "b");
                put("-.-.", "c");
                put("-..", "d");
                put(".", "e");
                put("..-.", "f");
                put("--.", "g");
                put("....", "h");
                put("..", "i");
                put(".---", "j");
                put("-.-", "k");
                put(".-..", "l");
                put("--", "m");
                put("-.", "n");
                put("---", "o");
                put(".--.", "p");
                put("--.-", "q");
                put(".-.", "r");
                put("...", "s");
                put("-", "t");
                put("..-", "u");
                put("...-", "v");
                put(".--", "w");
                put("-..-", "x");
                put("-.--", "y");
                put("--..", "z");
            }
        };
        String answer = "";
        String[] letterArr = letter.split(" ");
        for(String arr : letterArr) {
            answer += map.get(arr);
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String letter) {
        String morseStr = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',"
                + "'--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',"
                + "'--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',"
                + "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',"
                + "'-.--':'y','--..':'z'";
        String[] morseArr = morseStr.split(",");
        String[] letterArr = letter.split(" ");

        HashMap<String, String> morse = new HashMap<String, String>();

        for (int i = 0; i < morseArr.length; i++) {
            morseArr[i] = morseArr[i].replace("'", "");
            int idx = morseArr[i].indexOf(":");
            morse.put(morseArr[i].substring(0, idx), morseArr[i].substring(idx+1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterArr.length; i++) {
            sb.append(morse.get(letterArr[i]));
        }

        return sb.toString();
    }
}

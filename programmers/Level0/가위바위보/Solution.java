package Level0.가위바위보;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(char x : rsp.toCharArray()){
            if(x=='2') answer += "0";
            else if(x=='0') answer += "5";
            else if(x=='5') answer += "2";
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String rsp) {
        return Arrays.stream(rsp.split("")).map(s -> s.equals("2") ? "0" : s.equals("0") ? "5" : "2").collect(Collectors.joining());
    }
    //다른 풀이2
    public String solution2(String rsp) {
        String answer = "";
        String[] arr = rsp.split("");
        for(int i=0;i < arr.length; i++) {
            if(arr[i].equals("2")) answer += "0";
            else if(arr[i].equals("0")) answer += "5";
            else answer += "2";
        }
        return answer;
    }
    //다른 풀이3
    public String solution3(String rsp) {
        char[] cRsp = rsp.toCharArray();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i < cRsp.length; i++) {
            switch(cRsp[i]) {
                case '0' :
                    answer.append("5");
                    break;
                case '2' :
                    answer.append("0");
                    break;
                case '5' :
                    answer.append("2");
                    break;
            }
        }
        return answer.toString();
    }
    //다른 풀이4
    public String solution4(String rsp) {
        String answer = "";
        int len = rsp.length();

        for(int i =0; i<len; i++){
            if(rsp.substring(i,i+1).equals("2"))
                answer += "0";
            else if(rsp.substring(i,i+1).equals("5"))
                answer += "2";
            else if(rsp.substring(i,i+1).equals("0"))
                answer += "5";

        }
        return answer;
    }
}

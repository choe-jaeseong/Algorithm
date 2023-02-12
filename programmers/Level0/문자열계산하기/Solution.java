package Level0.문자열계산하기;

import java.util.Arrays;

public class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int sign = 1;
        for(String x : my_string.split(" ")){
            if(!(x.equals("+") || x.equals("-"))){
                answer += sign * Integer.parseInt(x);
            }
            else if (x.equals("+")) sign = 1;
            else if (x.equals("-")) sign = -1;
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(String myString) {
        return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }
    //다른 풀이2
    public int solution2(String my_string) {
        int answer = 0;
        boolean sign = true;
        String[] sarr = my_string.split(" ");
        for(int i=0; i<sarr.length; i++){
            if(i%2==0){
                answer += sign? Integer.parseInt(sarr[i]):-Integer.parseInt(sarr[i]);
            }else{
                sign = sarr[i].equals("+");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        
    }
}

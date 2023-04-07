package Level1.옹알이2;

public class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] basic = {"aya", "ye", "woo", "ma"};
        for(String x : babbling){
            for(int i=0; i<4; i++){
                x = x.replace(basic[i], i+"");
            }
            boolean flag = true;
            for(int i=0; i<x.length(); i++){
                if(!Character.isDigit(x.charAt(i)) || (i>0 && x.charAt(i-1)==x.charAt(i))) {
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
    //다른 풀이1
    public int solution1(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }
            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            babblings[i] = babblings[i].replace(" ", "");
            if(babblings[i].length()  == 0) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String x = "uuu";
        x = x.replace("u", "");
        System.out.println(x);
    }
}

package Level1.숫자문자열과영단어;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                answer = answer*10 + s.charAt(i)-'0';
            } else {
                int value = 0;
                switch(s.charAt(i)){
                    case 'o': 
                        value=1;
                        i+=2;
                        break;
                    case 't':
                        if(s.charAt(i+1)=='w'){
                            value=2;
                            i+=2;
                        } else{
                            value=3;
                            i+=4;
                        }
                        break;
                    case 'f':
                        if(s.charAt(i+1)=='o'){
                            value=4;
                            i+=3;
                        } else{
                            value=5;
                            i+=3;
                        }
                        break;
                    case 's':
                        if(s.charAt(i+1)=='i'){
                            value=6;
                            i+=2;
                        } else{
                            value=7;
                            i+=4;
                        }
                        break;
                    case 'e':
                        value=8;
                        i+=4;
                        break;
                    case 'n':
                        value=9;
                        i+=3;
                        break;
                    case 'z':
                        value=0;
                        i+=3;
                        break;
                }
                answer = answer*10 + value;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(String s) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }
        return Integer.parseInt(s);
    }
    //다른 풀이2
    public int solution2(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}

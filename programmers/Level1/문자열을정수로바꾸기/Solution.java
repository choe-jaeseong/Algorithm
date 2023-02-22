package Level1.문자열을정수로바꾸기;

public class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }

    public int solution1(String str){
        int sign = 1;
        int result = 0;
        for(char x : str.toCharArray()){
            if(x=='-'){
                sign = -1;
            } else if(x=='+'){
                sign = 1;
            } else {
                result = result * 10 + (x - '0');
            }
        }
        return sign * result;
    }

    //다른 풀이1
    public int getStrToInt(String str) {
        boolean Sign = true;
        int result = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-')
                Sign = false;
            else if(ch !='+')
                result = result * 10 + (ch - '0');
        }
        return Sign?1:-1 * result;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("-1234"));
    }
}

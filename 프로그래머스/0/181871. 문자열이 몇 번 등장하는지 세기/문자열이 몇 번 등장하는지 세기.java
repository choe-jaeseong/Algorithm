class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        char[] chars = myString.toCharArray();
        for(int i=0; i<chars.length - (pat.length() - 1); i++) {
            if(isRight(chars, i, pat)) 
                answer++;
        }
        return answer;
    }
    private static boolean isRight(char[] chars, int idx, String pat) {
        for(int i=idx; i<idx+pat.length(); i++) {
            if(chars[i] != pat.charAt(i - idx))
                return false;
        }
        return true;
    }
}
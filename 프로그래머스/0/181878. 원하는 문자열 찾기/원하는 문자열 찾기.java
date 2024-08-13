class Solution {
    public int solution(String myString, String pat) {
        String m = myString.toLowerCase();
        String p = pat.toLowerCase();
        return m.indexOf(p) >= 0 ? 1 : 0;
    }
}
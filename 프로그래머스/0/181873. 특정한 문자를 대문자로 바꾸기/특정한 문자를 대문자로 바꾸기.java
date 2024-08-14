class Solution {
    public String solution(String my_string, String alp) {
        String after = (char)(alp.charAt(0) - 32) + "";
        return my_string.replace(alp, after);
    }
}
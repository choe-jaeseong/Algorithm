class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] my = my_string.toCharArray();
        for(int i=s; i<s+overwrite_string.length(); i++) {
            my[i] = overwrite_string.charAt(i-s);
        }
        return new String(my);
    }
}
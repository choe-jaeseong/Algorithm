class Solution {
    public int[] solution(String my_string) {
        int[] count = new int[52];
        for(char c : my_string.toCharArray()) {
            if(Character.isUpperCase(c)) {
                count[c - 65]++;
            } else {
                count[c - 97 + 26]++;
            }
        }
        return count;
    }
}
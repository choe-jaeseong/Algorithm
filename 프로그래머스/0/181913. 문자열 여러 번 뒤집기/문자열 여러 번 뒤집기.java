class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] chars = my_string.toCharArray();
        for(int[] q : queries) {
            int s = q[0];
            int e = q[1];
            while(s <= e) {
                char tmp = chars[s];
                chars[s] = chars[e];
                chars[e] = tmp;
                s++;
                e--;
            }
        }
        return new String(chars);
    }
}
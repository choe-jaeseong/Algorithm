class Solution {
    public String solution(String my_string, int m, int c) {
        String[] arr = new String[my_string.length() / m];
        for(int i=0; i<arr.length; i++) {
            arr[i] = my_string.substring(i * m, (i + 1) * m);
        }
        String answer = "";
        for(int i=0; i<arr.length; i++) {
            answer += arr[i].charAt(c-1);
        }
        return answer;
    }
}
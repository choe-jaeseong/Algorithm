class Solution {
    public int solution(String myString, String pat) {
        char[] chars = myString.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(chars[i] == 'A') {
                chars[i] = 'B';
            } else {
                chars[i] = 'A';
            }
        }
        
        String newString = new String(chars);
        return newString.indexOf(pat) < 0 ? 0 : 1;
    }
}
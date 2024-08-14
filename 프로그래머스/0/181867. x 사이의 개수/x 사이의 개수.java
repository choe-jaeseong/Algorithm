class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        int size = arr.length;
        if(myString.charAt(myString.length() - 1) == 'x') size++;
        
        int[] answer = new int[size];
        for(int i=0; i<arr.length; i++) {
            answer[i] = arr[i].length();
        }
        return answer;
    }
}
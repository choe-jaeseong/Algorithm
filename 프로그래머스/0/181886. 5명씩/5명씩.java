class Solution {
    public String[] solution(String[] names) {
        int size = names.length / 5;
        if(names.length % 5 > 0) size++;
        
        String[] answer = new String[size];
        int idx = 0;
        for(int i=0; i<names.length; i+=5) {
            answer[idx++] = names[i];
        }
        return answer;
    }
}
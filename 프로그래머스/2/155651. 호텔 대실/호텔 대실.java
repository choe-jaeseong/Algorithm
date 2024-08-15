class Solution {
    
    public int solution(String[][] book_time) {
        int[] time = new int[10000];
        for(String[] book : book_time) {
            check(time, book);
        }
        int answer = 0;
        for(int t : time) answer = Math.max(answer, t);
        return answer;
    }
    private static void check(int[] time, String[] book) {
        int start = Integer.parseInt(book[0].replace(":", ""));
        int end = Integer.parseInt(book[1].replace(":", "")) + 10;
        if(end % 100 > 60) end += 40;
        for(int i=start; i<end; i++) {
            time[i]++;
        }
    }
}
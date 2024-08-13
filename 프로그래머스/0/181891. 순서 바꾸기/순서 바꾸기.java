class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int idx = 0;
        for(int i=n; i<n + num_list.length; i++) {
            int idx_nl = i % num_list.length;
            answer[idx++] = num_list[idx_nl];
        }
        return answer;
    }
}
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            int result = Integer.MAX_VALUE;
            for(int j=query[0]; j<=query[1]; j++) {
                if(arr[j] > query[2]) {
                    result = Math.min(result, arr[j]);
                }
            }
            answer[i] = result == Integer.MAX_VALUE ? -1 : result;
        }
        return answer;
    }
}
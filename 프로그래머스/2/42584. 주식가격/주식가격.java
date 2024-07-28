class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++) {
            int price = prices[i];
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[j] < price) break;
            }
        }
        return answer;
    }
}
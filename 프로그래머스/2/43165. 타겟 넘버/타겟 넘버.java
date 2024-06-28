class Solution {
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        findMethods(0, 0, numbers, target);
        return answer;
    }
    
    private static void findMethods(int sum, int idx, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) 
                answer++;
            return;
        }
        
        findMethods(sum + numbers[idx], idx + 1, numbers, target);
        findMethods(sum - numbers[idx], idx + 1, numbers, target);
    }
}
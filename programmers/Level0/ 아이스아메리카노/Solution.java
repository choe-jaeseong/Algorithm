class Solution {
    public int[] solution(int money) {
        int[] answer = {money/5500, money%5500};
        return answer;
    }

    //다른 사람 풀이
    public int[] solution1(int money) {
        return new int[] {money/5500, money%5500};
    }
}
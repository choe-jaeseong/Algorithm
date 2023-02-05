package Level0.각도기;

public class Solution {
    public int solution(int angle) {
        int answer = 0;
        if(angle < 90) answer = 1;
        else if(angle == 90) answer = 2;
        else if(angle < 180) answer = 3;
        else answer = 4;
        return answer;
    }

    //다른 사람 풀이(삼항 연산자)
    public int solution2(int angle){
        return angle == 180 ? 4 : angle < 90 ? 1 : angle == 90 ? 2 : angle > 90 ? 3 : 0;
    }
}

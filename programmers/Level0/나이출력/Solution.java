package Level0.나이출력;

import java.time.LocalDate;

public class Solution {
    public int solution(int age) {
        int answer = 0;
        answer = 2022-(age-1);
        return answer;
    }

    //다른 사람 풀이
    public int solution1(int age) {
        LocalDate today = LocalDate.now();
        return today.getYear() - age + 1;
    }
}


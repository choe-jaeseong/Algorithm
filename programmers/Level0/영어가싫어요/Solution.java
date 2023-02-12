package Level0.영어가싫어요;

import java.util.Map;

public class Solution {
    public long solution(String numbers) {
        numbers = numbers.replace("one", "1").replace("two","2").replace("three","3").replace("four","4").replace("five","5").replace("six","6").replace("seven","7").replace("eight","8").replace("nine","9").replace("zero","0");
        return Long.parseLong(numbers);
    }

    //다른 풀이1
    public long solution1(String numbers) {

        String[] numbers_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numbers_arr.length; i++) {
            numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
        }

        long answer = Long.parseLong(numbers);
        return answer;
    }

    //다른 풀이2
    public long solution2(String numbers) {
        return Long.parseLong(
                numbers.replaceAll("zero", "0")
                        .replaceAll("one", "1")
                        .replaceAll("two", "2")
                        .replaceAll("three", "3")
                        .replaceAll("four", "4")
                        .replaceAll("five", "5")
                        .replaceAll("six", "6")
                        .replaceAll("seven", "7")
                        .replaceAll("eight", "8")
                        .replaceAll("nine", "9")
        );
    }

    //다른 풀이3
    private static final Map<String, Integer> CONTAINS = Map.of("zero", 0, "one", 1, "two", 2,"three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);
    public long solution3(String numbers) {
        StringBuilder answer = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (String s : numbers.split("")) {
            builder.append(s);
            if (CONTAINS.containsKey(builder.toString())) {
                answer.append(CONTAINS.get(builder.toString()));
                builder = new StringBuilder();
            }
        }
        return Long.parseLong(answer.toString());
    }
    
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("onetwothreefourfivesixseveneightnine"));
    }
}

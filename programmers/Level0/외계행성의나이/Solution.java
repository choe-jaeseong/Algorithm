package Level0.외계행성의나이;

import java.util.stream.Collectors;

class Solution {
    public String solution(int age) {
        String answer = age + "";
        answer = answer.replace("0","a").replace("1","b").replace("2","c").replace("3","d").replace("4","e").replace("5","f").replace("6","g").replace("7","h").replace("8","i").replace("9","j");
        return answer;
    }
		//다른 풀이1
		public String solution1(int age) {
        return String.valueOf(age).chars().mapToObj(operand -> String.valueOf((char) (49 + operand))).collect(Collectors.joining());
    }
		//다른 풀이2
		public String solution2(int age) {
        String answer = "";
        String[] alpha = new String[]{"a","b","c","d","e","f","g","h","i","j"};

        while(age>0){
            answer = alpha[age % 10] + answer;
            age /= 10;
        }

        return answer;
    }
}


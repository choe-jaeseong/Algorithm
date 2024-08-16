class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] exp =  binomial.split(" ");
        int a = Integer.parseInt(exp[0]);
        int b = Integer.parseInt(exp[2]);
        switch(exp[1]) {
                case "+" -> answer = a + b;
                case "-" -> answer = a - b;
                case "*" -> answer = a * b;
        }
        return answer;
    }
}
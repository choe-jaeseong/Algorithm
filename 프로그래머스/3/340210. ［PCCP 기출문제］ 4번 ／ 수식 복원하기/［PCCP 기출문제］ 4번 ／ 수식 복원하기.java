import java.util.*;

class Solution {
    private static Map<String, Set<Integer>> map = new HashMap<>();
    private static List<String> answer = new ArrayList<>();
    private static Set<Integer> baseSet = new HashSet<>();
    public String[] solution(String[] expressions) {
        //가능한 진법 남기기
        int startBase = findStartBase(expressions);
        System.out.println(startBase);
        for(int i = startBase; i <= 9; i++) baseSet.add(i);
        for(String exp : expressions) {
            for(int i=startBase; i<=9; i++) {
                if(baseSet.contains(i) && !isPossible(exp, i))
                    baseSet.remove(i);
            }
        }
        //가능한 진법으로 계산하기
        for(String exp : expressions) {
            if(exp.charAt(exp.length() - 1) == 'X') {
                map.put(exp, new HashSet<>());
                for(int base : baseSet) {
                    calculate(exp, base);
                }
                Set<Integer> resultSet = map.get(exp);
                if(resultSet.size() > 1) {
                    answer.add(exp.substring(0, exp.length() - 1) + "?");
                } else {
                    int res = 0;
                    for(int x : resultSet) {
                        res = x;
                    }
                    answer.add(exp.substring(0, exp.length() - 1) + res);
                }
            }
        }
        String[] ans = new String[answer.size()];
        for(int i=0; i<ans.length; i++) ans[i] = answer.get(i);
        return ans;
    }
    private static void calculate(String exp, int base) {
        String[] splits = exp.split(" ");
        int a = Integer.parseInt(splits[0], base);
        int b = Integer.parseInt(splits[2], base);
        
        if(splits[1].equals("+")) map.get(exp).add(Integer.parseInt(Integer.toString(a + b, base)));
        else map.get(exp).add(Integer.parseInt(Integer.toString(a - b, base)));
    }
    private static boolean isPossible(String exp, int base) {
        if(exp.charAt(exp.length() - 1) == 'X') return true;
        
        String[] splits = exp.split(" ");
        int a = Integer.parseInt(splits[0], base);
        int b = Integer.parseInt(splits[2], base);
        int c = Integer.parseInt(splits[4], base);
        
        return splits[1].equals("+") ? a + b == c : a - b == c;
    }
    private static int findStartBase(String[] expressions) {
        int max = 0;
        for(String exp : expressions) {
            for(char c : exp.toCharArray()) {
                if(Character.isDigit(c)) {
                    max = Math.max(max, c - '0');
                }
            }
        }
        return max + 1;
    }
}
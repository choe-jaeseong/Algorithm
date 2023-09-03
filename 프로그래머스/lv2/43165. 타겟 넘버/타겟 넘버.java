import java.util.HashSet;

class Solution {
    
    private static HashSet<String> set = new HashSet<>();
    public int solution(int[] numbers, int target) {
        DFS(0, numbers, target, 0, "");
        return set.size();
    }
    private static void DFS(int L, int[] numbers, int target, int result, String exp){
        if(L==numbers.length){
            if(result == target && !set.contains(exp)) 
                set.add(exp);
            return;
        }
        DFS(L+1, numbers, target, result + numbers[L], exp + "+" + numbers[L]);
        DFS(L+1, numbers, target, result - numbers[L], exp + "-" + numbers[L]);
    }
}
/*
1. DFS 실행
    - 깊이가 정수의 갯수가 되고, 결과값이 target과 같을 때, set 자료구조에 있는지 확인하고 set에 저장.
    - 아니면, DFS 두 가지(덧셈, 뺄셈) 실행
    - 매개변수 (깊이, numbers, target, result, 작성한 식)
*/
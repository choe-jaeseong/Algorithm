package Book.재귀.하노이의탑;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    //방법 2 - 메서드의 반환 대신 리스트 매개변수를 이용하여 과정을 기록
    private void hanoi(int n, int from, int to, List<int[]> process){
        if(n == 1){
            process.add(new int[] {from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n-1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n-1, empty, to, process);
    }
    public int[][] solution(int n){
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }

    // 방법 1 - 비효율적 (매번 리스트를 만들어 대입하는 과정은 비효율적이다.)
    // private List<int[]> hanoi(int n, int from, int to){
    //     if(n == 1) return List.of(new int[] {from, to});
    
    //     int empty = 6 - from - to;
    //     List<int[]> result = new ArrayList<>();
    //     result.addAll(hanoi(n-1, from, empty));
    //     result.addAll(hanoi(1, from, to));
    //     result.addAll(hanoi(n-1, empty, to));
    //     return result;
    // }
    // public int[][] solution(int n){
    //     return hanoi(n, 1, 3).toArray(new int[0][]);
    // }
}

package Level0.짝수는싫어요;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int n) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i%2==1) list.add(i);
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for(int x : T.solution(10)) System.out.println(x);
    }
}

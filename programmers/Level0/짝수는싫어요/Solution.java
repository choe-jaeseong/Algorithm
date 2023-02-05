package Level0.짝수는싫어요;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution1(int n) {
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

    //다른 사람 풀이1(스트림 활용)
    public int[] solution2(int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }

    //다른 사람 풀이2()
    public int[] solution3(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i % 2 == 1){
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();  //stream mapToInt
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for(int x : T.solution1(10)) System.out.println(x);
    }
}

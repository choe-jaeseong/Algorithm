package Level1.로또의최고순위와최저순위;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class Solution {
    static int[] check = new int[6];
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt_correct = 0;
        int cnt_zero = 0;
        for(int i=0; i<6; i++){
            if(lottos[i]==0) cnt_zero++;
            for(int j=0; j<6; j++){
                if(check[j]==0 && lottos[i]==win_nums[j]){
                    check[j]=1;
                    cnt_correct++;
                }
            }
        }
        if(cnt_correct>=2) answer[1]=7-cnt_correct;
        else answer[1]=6;
        if(cnt_correct+cnt_zero>=2) answer[0]=7-cnt_correct-cnt_zero;
        else answer[0]=6;
        return answer;
    }

    //다른 풀이1
    public int[] solution1(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
    
    //다른 풀이2
    public int[] solution2(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
    
    //다른 풀이3
    public int[] solution3(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int answer = 0;
        int hidden = 0;

        Arrays.sort(win_nums);
        for (int i = 0; i < lottos.length; i++)
            if (Arrays.binarySearch(win_nums, lottos[i]) > -1)
                answer++;
            else if (lottos[i] == 0)
                hidden++;

        return new int[] {rank[answer + hidden], rank[answer]};
    }
}

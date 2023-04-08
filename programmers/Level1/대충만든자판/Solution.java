package Level1.대충만든자판;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int idx = 0;
        for(String x : targets){        //target에서 s하나 꺼내기
            for(char y : x.toCharArray()){            //s의 알파벳 체크
                int touches = 0;
                for(String key : keymap){
                    int i = key.indexOf(y)+1;
                    if(touches==0) touches = i;
                    else touches = i==0 ? touches : Math.min(touches, i);
                }
                if(touches==0){
                    answer[idx]=-1;
                    break;
                }
                else answer[idx]+=touches;
            }
            idx++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"AGZ", "BSSS"};
        String[] arr1 = {"ASA", "BGZ"};
        for(int x : T.solution(arr, arr1)) System.out.print(x + " ");
    }
}

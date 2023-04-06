package Level1.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Round implements Comparable<Round>{
    public int a;   //라운드 번호
    public double b;//실패율
    public Round(int a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Round o){
        if(this.b==o.b) return this.a-o.a;
        else if(o.b < this.b) return -1;
        else return 1;
    }
}

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Round> arr = new ArrayList<>();
        double participants = stages.length;
        for(int i=0; i<N; i++){ //라운드의 값 찾기
            int cnt = 0;
            for(int j=0; j<stages.length; j++){ //각 라운드마다 참여자와 실패자 비율 찾기
                if(stages[j]==i+1) cnt++;
            }
            if(cnt==0) arr.add(new Round(i+1, 0));
            else arr.add(new Round(i+1, cnt/participants));
            participants -= cnt;
        }
        Collections.sort(arr);
        for(int i=0; i<N; i++){
            answer[i]=arr.get(i).a;
        }
        return answer;
    }


    //다른 풀이1
    public int[] solution1(int N, int[] stages) {
        int[] answer = new int[N];
        double[] currentStage = new double[N+1];
        double[] totalUser = new double[N+1];
        List<double[]> fail = new ArrayList<double[]>();
        
        for (int i=0; i<stages.length; i++) {
            currentStage[stages[i]-1]++; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            for (int j=0; j<stages[i]; j++) {
                totalUser[j]++; // 스테이지에 도달한 플레이어 수
            }
        }
        
        // 스테이지별 실패율 추출
        for (int i=0; i<N; i++) {
            if(totalUser[i] == 0) {
                fail.add(new double[]{i,0});
            } else {
                fail.add(new double[]{i,currentStage[i] / totalUser[i]});
            }
        }
        
        fail.sort((a,b)->Double.compare(b[1],a[1]));  //람다식 알기
        
        for (int i=0; i<fail.size(); i++) {
            answer[i] = (int)fail.get(i)[0]+1;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        for(int x : T.solution(5, arr)){
            System.out.println(x + " ");
        }
    }
}

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        //최소 힙, 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            //삽입 시 최소 힙, 최대 힙에 value 넣기
            if (judge.equals("I")) {
                pq.offer(value);
                maxPq.offer(value);
                continue;
            }

            //빈 큐에 데이터를 삭제 요청 경우 연산 무시
            if (judge.equals("D") && pq.size() < 1)
                continue;
            
            //D이면서 value -1
            //최소 힙에서 poll후 최대힙에서 해당 원소 삭제
            if(value == -1) {
                int min = pq.poll();
                maxPq.remove(min);
                continue;
            }

            //D이면서 value 1
            //최대 힙에서 poll후 최소힙에서 해당 원소 삭제
            int max = maxPq.poll();
            pq.remove(max);
        }
        if(pq.size() > 0 ) {
            answer[0] = maxPq.poll();
            answer[1] = pq.poll();
        }
        return answer;
    }
}
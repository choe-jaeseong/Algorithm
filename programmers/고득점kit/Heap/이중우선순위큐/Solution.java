package 고득점kit.Heap.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    //나의 답 (오답)
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        boolean flag = true;
        PriorityQueue<Integer> p = new PriorityQueue<>();  //오름차순
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1); //내림차순
        for(String x : operations){
            String[] arr = x.split(" ");
            if(arr[0].equals("I")){
                if(flag) p.offer(Integer.parseInt(arr[1]));
                else q.offer(Integer.parseInt(arr[1]));
            } else if(arr[1].equals("1")){ //"D 1" 최댓값삭제 q
                if(flag){
                    if(p.isEmpty()) continue;
                    else{
                        while(!p.isEmpty()) q.offer(p.poll());
                        q.poll();
                        flag=false;
                    }
                } else {
                    q.poll();
                }
            } else {                                //"D -1" 최솟값삭제 p
                if(flag) p.poll();
                else {
                    if(q.isEmpty()) continue;
                    else {
                        while(!q.isEmpty()) p.offer(q.poll());
                        p.poll();
                        flag=true;
                    }
                }
            }
        }

        if(flag){
            if(p.isEmpty()) return answer;
            else {
                answer[1]=p.poll();
                int tmp = 0;
                for(int x : p) tmp = x;
                answer[0]=tmp;
            }
        } else {
            if(q.isEmpty()) return answer;
            else {
                answer[0]=q.poll();
                int tmp = 0;
                for(int x : q) tmp = x;
                answer[1]=tmp;
            }
        }
        return answer;
    }

    //다른 풀이1
    public int[] Solution1(String[] operations) {
        int[] answer = new int[2];
        //최소 힙, 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            StringTokenizer st = new StringTokenizer(op);
            String judge = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            //빈 큐에 데이터를 삭제 요청 경우 연산 무시
            if (pq.size() < 1 && judge.equals("D"))
                continue;

            //삽입 시 최소 힙, 최대 힙에 value 넣기
            if (judge.equals("I")) {
                pq.offer(value);
                maxPq.offer(value);
                continue;
            }

            //나머지 경우는 D이면서 value값이 1인지 -1인지 이므로
            //0보다 작은 경우 최소 힙에서 poll후 최대힙에서 해당 원소 삭제
            if(value < 0) {
                int min = pq.poll();
                maxPq.remove(min);
                continue;
            }

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
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        for(int x : T.solution(arr)){
            System.out.print(x+" ");
        }
    }
}

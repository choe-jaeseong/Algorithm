import java.util.*;

class Solution {
    private static int[][] phone = {
        {3, 1}, 
        {0,0}, {0,1}, {0,2},
        {1,0}, {1,1}, {1,2},
        {2,0}, {2,1}, {2,2},
    };
    private static Set<Integer> left = new HashSet<>(List.of(1,4,7));
    private static Set<Integer> right = new HashSet<>(List.of(3,6,9));
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Hand lh = new Hand(3,0);
        Hand rh = new Hand(3,2);
        
        for(int number : numbers) {
            if (left.contains(number)) {
                sb.append("L");
                lh.handle(number);
            } else if (right.contains(number)) {
                sb.append("R");
                rh.handle(number);
            } else {
                // 거리 비교
                int dist_l = lh.getDistance(number);
                int dist_r = rh.getDistance(number);
                if(dist_l < dist_r) {
                    sb.append("L");
                    lh.handle(number);
                } else if(dist_l > dist_r) {
                    sb.append("R");
                    rh.handle(number);
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        lh.handle(number);
                    } else {
                        sb.append("R");
                        rh.handle(number);
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    
    class Hand {
        int x;
        int y;

        Hand(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getDistance(int number) {
            int[] loc = phone[number];
            return Math.abs(loc[0] - x) + Math.abs(loc[1] - y);
        }

        void handle(int number) {
            int[] loc = phone[number];
            x = loc[0];
            y = loc[1];
        }
    }
}


/*
1. 각 번호의 x, y 좌표를 입력한 배열을 만든다.
2. 왼손 번호(1,4,7), 오른손 번호(3,6,9) set 만들기
3. 왼손 위치, 오른손 위치 만들기(각 시작 지점)
4. 판단해서 손 옮기기
    - 왼손 set 인지 
    - 오른손 set 인지
    - 해당 번호 위치 와 왼손 오른손 거리 비교
        - 가까운 손을 움직이기
        - 거리가 같다면 손잡이로 움직이기
*/
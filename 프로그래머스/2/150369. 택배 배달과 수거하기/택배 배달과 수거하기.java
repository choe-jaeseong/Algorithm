class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        //idx를 끝지점부터 0 까지 이동하면서 거리 구하기
        int idx = n - 1;
        while(idx >= 0) {
            //d, p 중에 남아있는 가장 끝 idx 찾기
            while(idx>=0 && deliveries[idx] == 0 && pickups[idx] == 0) idx--;
            
            //d 에서 cap 만큼 제거하기
            int c = cap;
            for(int i=idx; i>=0 && c > 0; i--) {
                if(c >= deliveries[i]) {
                    c -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= c;
                    c = 0;
                    break;
                }
            }
            
            //p 에서 cap 만큼 제거하기
            c = cap;
            for(int i=idx; i>=0 && c > 0; i--) {
                if(c >= pickups[i]) {
                    c -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= c;
                    c = 0;
                    break;
                }
            }
            
            //answer 에 (idx + 1) * 2 더하기
            answer += (idx + 1) * 2;
        }
        
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{x, 0});
        boolean[] visited = new boolean[1000001];
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if(tmp[0] == y) return tmp[1];
            else if(tmp[0] > y) continue;
            if(visited[tmp[0]]) continue;
            visited[tmp[0]] = true;
            
            if(tmp[0] + n <= y) pq.add(new int[]{tmp[0] + n, tmp[1] + 1});
            if(tmp[0] * 2 <= y) pq.add(new int[]{tmp[0] * 2, tmp[1] + 1});
            if(tmp[0] * 3 <= y) pq.add(new int[]{tmp[0] * 3, tmp[1] + 1});
        }
        return -1;
    }
}
import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        //도로 생성
        int[][] road_arr = new int[N+1][N+1];
        for(int[] r : road_arr) Arrays.fill(r, 10001);
        for(int[] r : road) {
            road_arr[r[0]][r[1]] = Math.min(road_arr[r[0]][r[1]], r[2]);
            road_arr[r[1]][r[0]] = Math.min(road_arr[r[1]][r[0]], r[2]);
        }
        //마을 최단 경로
        int[] cities = new int[N + 1];
        Arrays.fill(cities, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1,0});
        
        boolean[] visited = new boolean[N + 1];
        while(!pq.isEmpty()) {
            int[] step = pq.poll();
            int to = step[0];
            int cost = step[1];
            
            if(visited[to]) continue;
            visited[to] = true;
            cities[to] = cost;
            
            for(int i=1; i<=N; i++)
                if(road_arr[to][i] <= 10000)
                    pq.add(new int[]{i, cost + road_arr[to][i]});
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++)
            if(cities[i] <= K) 
                answer++;
        
        return answer;
    }
}

/*
다익스트라 알고리즘
1. 시작점을 넣는다.
2. 각 마을까지 거리를 최단으로 갱신한다.
3. 갈 수 있는 경로를 넣는다.
*/
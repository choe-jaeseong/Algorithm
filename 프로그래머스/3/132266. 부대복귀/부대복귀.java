import java.util.*;

class Solution {
    
    private static int[] d;
    private static boolean[] visited;
    private static List<List<Integer>> r = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        makingRoads(n, roads);
        
        d = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        Dijkstra(roads, destination);
        
        int[] answer = new int[sources.length];
        for(int i=0; i<answer.length; i++) {
            answer[i] = d[sources[i]] == Integer.MAX_VALUE ? -1 : d[sources[i]];
        }
        return answer;
    }
    private static void makingRoads(int n, int[][] roads) {
        for(int i=0; i<=n; i++) r.add(new ArrayList<>());
        for(int[] road : roads) {
            r.get(road[0]).add(road[1]);
            r.get(road[1]).add(road[0]);
        }
    }
    private static void Dijkstra(int[][] roads, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((r1, r2) -> r1[1] - r2[1]);
        d[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int to = tmp[0];
            int dist = tmp[1];
            // if(visited[to]) continue;
            // visited[to] = true;
            // d[to] = dist;
            
            for(int next : r.get(to)) {
                if(d[next] > dist + 1) {
                    d[next] = dist + 1;
                    pq.add(new int[]{next, dist + 1});
                }
            }
        }
    }
}

/*
다익스트라 알고리즘
시작점 = 부대
*/
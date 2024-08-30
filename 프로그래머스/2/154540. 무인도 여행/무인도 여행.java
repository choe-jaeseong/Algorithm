import java.util.*;

class Solution {
    
    private static boolean[][] visited;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    add(result, maps, i, j);
                }
            }
        }
        
        if(result.size() == 0) return new int[]{-1};
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) answer[i] = result.get(i);
        Arrays.sort(answer);
        return answer;
    }
    
    private static void add(List<Integer> result, String[] maps, int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        count += maps[x].charAt(y) - '0';
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(!(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length())) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                visited[nx][ny] = true;
                count += maps[nx].charAt(ny) - '0';
                q.add(new int[]{nx, ny});
            }
        }
        result.add(count);
    }
}
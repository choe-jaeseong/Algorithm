import java.util.*;

class Solution {
    
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));
        isVisited[0][0] = true;
        
        while(!queue.isEmpty()) {
            State state = queue.poll();
            
            if(state.x == maps.length - 1 && state.y == maps[0].length - 1) 
                return state.step;
            
            for(int i=0; i<4; i++) {
                int nx = state.x + dx[i];
                int ny = state.y + dy[i];
                
                if(!(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length)) continue;
                if(maps[nx][ny] == 0) continue;
                if(isVisited[nx][ny]) continue;
                
                isVisited[nx][ny] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }
        }
        
        return -1;
    }
    
}
class State {
    int x;
    int y;
    int step;
    
    State(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
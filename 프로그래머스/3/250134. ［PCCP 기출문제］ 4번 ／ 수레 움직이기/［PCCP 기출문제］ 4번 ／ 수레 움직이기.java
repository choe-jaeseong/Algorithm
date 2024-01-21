class Solution {
    
    static int[][] map, ch1, ch2;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] StartRed = new int[2];  //x, y
    static int[] StartBlue = new int[2]; //x, y
    static int[] EndRed = new int[2];  //x, y
    static int[] EndBlue = new int[2]; //x, y
    static int INF = Integer.MAX_VALUE;
    static int answer = INF;
    
    public int solution(int[][] maze) {
        map = maze;
        ch1 = new int[maze.length][maze[0].length];
        ch2 = new int[maze.length][maze[0].length];
        
        findRedAndBlue();
        ch1[StartRed[0]][StartRed[1]] = 1;
        ch2[StartBlue[0]][StartBlue[1]] = 1;
        
        move(StartRed[0], StartRed[1], StartBlue[0], StartBlue[1], 0);
        
        if(answer == INF) return 0;
        return answer;
    }
    
    static void move(int rx, int ry, int bx, int by, int count) {
        // System.out.println(rx + " " + ry + " " + bx + " " + by + " " + count);
        
        if(rx == EndRed[0] && ry == EndRed[1] && bx == EndBlue[0] && by == EndBlue[1]) {
            // System.out.println("answer : " + rx + " " + ry + " " + bx + " " + by + " " + count);
            answer = Math.min(answer, count);
            return;
        }
        
        int nrx=0, nry=0, nbx=0, nby=0;
        for(int i=0; i<4; i++) {
            if(rx == EndRed[0] && ry == EndRed[1]) {
                nrx = rx;
                nry = ry;
            } else {
                nrx = dx[i] + rx;
                nry = dy[i] + ry;
                if(!(nrx>=0 && nrx<map.length && nry>=0 && nry<map[0].length)) continue;    //범위 확인
                if(map[nrx][nry] == 5) continue;                                            //벽 확인
                if(ch1[nrx][nry] == 1) continue;                                            //방문 확인
            }
            for(int j=0; j<4; j++) {
                if(bx == EndBlue[0] && by == EndBlue[1]) {
                    nbx = bx;
                    nby = by;
                } else {
                    nbx = dx[j] + bx;
                    nby = dy[j] + by;
                    if(!(nbx>=0 && nbx<map.length && nby>=0 && nby<map[0].length)) continue;    //범위 확인
                    if(map[nbx][nby] == 5) continue;                                            //벽 확인
                    if(ch2[nbx][nby] == 1) continue;                                            //방문 확인
                }
                
                if(nrx == nbx && nry == nby) continue; //두 수레 위치가 동일한지 확인
                if(nrx == bx && nry == by && nbx == rx && nby == ry) continue; //두 수레 위치가 서로 바뀌었는지 확인
                
                ch1[nrx][nry] = 1;
                ch2[nbx][nby] = 1;
                move(nrx, nry, nbx, nby, count + 1);
                ch1[nrx][nry] = 0;
                ch2[nbx][nby] = 0;
            }
        }
    }
    
    static void findRedAndBlue() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == 1) {
                    StartRed[0] = i;
                    StartRed[1] = j;
                } else if (map[i][j] == 2) {
                    StartBlue[0] = i;
                    StartBlue[1] = j;
                } else if (map[i][j] == 3) {
                    EndRed[0] = i;
                    EndRed[1] = j;
                } else if (map[i][j] == 4) {
                    EndBlue[0] = i;
                    EndBlue[1] = j;
                } 
            }
        }
    }
}

/*
핵심 아이디어
직접 구현 (백트래킹)


풀이 방법
0. 초기 세팅
- 각 수레에 대한 방문 배열(2개)을 만든다.
- 턴을 세며 수레를 이동한다. (백트래킹)
- 결과값이 INF 이면 출력 0. INF 아니면 출력 result.

이동 시, 다른 수레와 자리를 서로 옮기는 경우는 못하도록 막는다.

*/
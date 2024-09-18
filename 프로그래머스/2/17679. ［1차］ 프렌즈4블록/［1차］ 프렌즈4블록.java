import java.util.*;

class Solution {
    private static Set<String> set;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        //보드 생성
        char[][] chars = new char[m][n];
        for(int i=0; i<m; i++) chars[i] = board[i].toCharArray();

        while(true) {
            // 1. 보드 전체에 가능한 사각형의 좌표를 모두 저장한다(Set).
            int count = isPossible(chars);
            if(count == 0) break;
            answer += count;
            
            // 2. 좌표의 개수가 0보다 크면 좌표에 해당하는 칸을 '0'으로 초기화한다.
            for(String s : set) {
                String[] loc = s.split(" ");
                int r = Integer.parseInt(loc[0]);
                int c = Integer.parseInt(loc[1]);
                chars[r][c] = '0';
            }
            
            // 3. 열 탐색 -> 아래 칸이 될때까지 모두 이동한다.
            for(int i=0; i<n; i++) move(i, chars);
        }
        
        return answer;
    }
    private static void move(int c, char[][] chars) {
        int r = chars.length - 1;
        while(true) {
            while(r >= 0 && chars[r][c] != '0') r--;
            if(r <= 0) break;
            
            int nr = r - 1;
            while(nr >= 0 && chars[nr][c] == '0') nr--;
            if(nr < 0) break;
            
            chars[r][c] = chars[nr][c];
            chars[nr][c] = '0';
            
            r--;
        }
    }
    private static int isPossible(char[][] chars) {
        set = new HashSet<>();
        
        for(int i=0; i<chars.length - 1; i++) {
            for(int j=0; j<chars[0].length - 1; j++) {
                char c = chars[i][j];
                if(c == '0') continue;
                if(chars[i][j + 1] == c && chars[i + 1][j] == c && chars[i + 1][j + 1] == c) {
                    set.add(i + " " + j);
                    set.add((i + 1) + " " + j);
                    set.add(i + " " + (j + 1));
                    set.add((i + 1) + " " + (j + 1));
                    System.out.println(i + " " + j);
                }
            }
        }
        return set.size();
    }
}

/*
# 구현
1. 보드 전체에 가능한 사각형의 좌표를 모두 저장한다(Set).
2. 좌표의 개수가 0보다 크면 좌표에 해당하는 칸을 '0'으로 초기화한다.
3. 열 탐색 -> 아래 칸이 될때까지 모두 이동한다.
4. 1 ~ 3 반복
*/
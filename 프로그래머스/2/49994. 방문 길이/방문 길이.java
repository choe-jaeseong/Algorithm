import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int[] loc = new int[2];
        for(char d : dirs.toCharArray()) {
            switch(d) {
                case 'U' -> {
                    int[] next = new int[2];
                    next[0] = loc[0] + 1;
                    next[1] = loc[1];
                    if(!isInRange(next[0], next[1])) continue;
                    add(set, loc, next);
                    loc = next;
                }
                case 'D' -> {
                    int[] next = new int[2];
                    next[0] = loc[0] - 1;
                    next[1] = loc[1];
                    if(!isInRange(next[0], next[1])) continue;
                    add(set, loc, next);
                    loc = next;
                }
                case 'R' -> {
                    int[] next = new int[2];
                    next[0] = loc[0];
                    next[1] = loc[1] + 1;
                    if(!isInRange(next[0], next[1])) continue;
                    add(set, loc, next);
                    loc = next;
                }
                case 'L' -> {
                    int[] next = new int[2];
                    next[0] = loc[0];
                    next[1] = loc[1] - 1;
                    if(!isInRange(next[0], next[1])) continue;
                    add(set, loc, next);
                    loc = next;
                }
            }
        }
        return set.size();
    }
    private static void add(Set<String> set, int[] loc, int[] next) {
        int[][] tmp = new int[2][2];
        tmp[0] = loc;
        tmp[1] = next;
        Arrays.sort(tmp, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        set.add("" + tmp[0][0] + tmp[0][1] + tmp[1][0] + tmp[1][1]);
    }
    private static boolean isInRange(int x, int y) {
        return (x>=-5 && x<=5 && y>=-5 && y<=5);
    }
}
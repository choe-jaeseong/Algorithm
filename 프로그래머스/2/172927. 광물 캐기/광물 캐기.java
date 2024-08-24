class Solution {
    
    private static int[][] t = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    private static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        DFS(0, 0, picks, minerals);
        return answer;
    }
    private static boolean isDone(int[] picks) {
        for(int p : picks) {
            if(p > 0) return false;
        }
        return true;
    }
    private static void DFS(int idx, int sum, int[] picks, String[] minerals) {
        if(idx == minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }
        
        if(isDone(picks)) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                int tired = 0;
                for(int j=idx; j<idx+5 && j<minerals.length; j++) {
                    String mineral = minerals[j];
                    if(mineral.equals("diamond")) {
                        tired += t[i][0];
                    } else if(mineral.equals("iron")) {
                        tired += t[i][1];
                    } else {
                        tired += t[i][2];
                    }
                }
                DFS(idx + 5 > minerals.length ? minerals.length : idx + 5
                    , sum + tired, picks, minerals);
                picks[i]++;
            }
        }
    }
}
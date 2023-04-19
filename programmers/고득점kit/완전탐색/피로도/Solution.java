package 고득점kit.완전탐색.피로도;

public class Solution {
    int[] ch;
    int max = 0;
    int cnt = 0;
    public void DFS(int L, int k, int[][] dungeons){
        if(k==0 || L==dungeons.length){
            max = Math.max(max, cnt);
        }
        for(int i=0; i<dungeons.length; i++){
            if(ch[i]==0){
                if(k>=dungeons[i][0]){
                    ch[i]=1;
                    cnt++;
                    DFS(L+1, k-dungeons[i][1], dungeons);
                    ch[i]=0;
                    cnt--;
                } else {
                    max = Math.max(max, cnt);
                }
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        ch = new int[dungeons.length];
        DFS(0, k, dungeons);
        return answer=max;
    }


    //다른 풀이1
    public static boolean check[];
    public static int ans = 0;

    public int solution1(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }
    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }

    //다른 풀이2
    int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for(int[] d : dungeons) {
            int a = d[0], b = d[1];
            if(a <= k) {
                d[0] = 9999;
                cnt = Math.max(1 + dfs(k - b, dungeons), cnt);
                d[0] = a;
            }
        }
        return cnt;
    }
    public int solution2(int k, int[][] dungeons) {
        int answer = -1;
        return dfs(k, dungeons);
    }
}


/*
 * 1. 순열 구하기  0 1 2/ 0 2 1/ 1 0 2/ 1 2 0/ 2 0 1/ ...
 * 2. 순서대로 했을 때 탐험가능한 경우의 수의 최댓값 구하기.
 */
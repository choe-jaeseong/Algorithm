package 고득점kit.DFS_BFS.타겟넘버;

public class Solution {
    int[] ch;
    int ans = 0;
    public void DFS(int L, int sum, int[] numbers, int target){
        if(L==ch.length){
            if(sum==target) ans++;
        } else {
            ch[L]=1;
            DFS(L+1, sum+ch[L]*numbers[L], numbers, target);
            ch[L]=-1;
            DFS(L+1, sum+ch[L]*numbers[L], numbers, target);
        }
    }
    public int solution(int[] numbers, int target) {
        ch = new int[numbers.length];
        DFS(0, 0, numbers, target);
        return ans;
    }

    //다른 풀이1
    public int solution1(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {4, 1, 2, 1};
        System.out.println(T.solution(arr, 4));
    }
}

/*
 * 
 */

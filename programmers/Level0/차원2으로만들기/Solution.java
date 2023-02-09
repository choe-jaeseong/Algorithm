package Level0.차원2으로만들기;

public class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        for(int i=0; i<num_list.length; i++){
            int j=i/n;
            int k=i%n;
            answer[j][k] = num_list[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,2,3,4,5,6};
        for(int[] x : T.solution(arr,2)) System.out.println(x[0]+" "+x[1]);
    }
}

package Level0.평행;

public class Solution {
    public int combination(int n, int r){
        if(n==r) return 1;
        if(r==1) return n;
        return combination(n-1,r-1)+combination(n-1,r);
    }
    public int solution(int[][] dots) {
        System.out.println(dots.length);
        int len = combination(dots.length,2), k=0;
        System.out.println(len);
        int[][] arr = new int[len][2];
        for(int i=0; i<dots.length-1; i++){
            for(int j=i+1; j<dots.length; j++){
                arr[k][0]=dots[i][0]-dots[j][0];
                arr[k][1]=dots[i][1]-dots[j][1];
                k++;
            }
        }
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                if(arr[i][1] == (arr[i][0]/arr[j][0]*arr[j][1]))
                    return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] dots = {{1,4}, {9, 2}, {3, 8}, {11, 6}};
        System.out.println(T.solution(dots));
    }
}

package Dynamic_programming;

import java.util.Scanner;

public class dy03_최대부분증가수열LIS {
    int[] dy;
    public int solution(int n, int[] arr){
        int answer = 0;
        dy = new int[n];
        dy[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(arr[i]>arr[j]){
                    if(max < dy[j]){
                        max = dy[j];
                    }
                }
            }
            dy[i]=max+1;
            // if(answer < dy[i]) answer = dy[i];
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        dy03_최대부분증가수열LIS T = new dy03_최대부분증가수열LIS();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
        sc.close();
    }
}

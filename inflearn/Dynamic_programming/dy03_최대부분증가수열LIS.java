package Dynamic_programming;

import java.util.Scanner;

public class dy03_최대부분증가수열LIS {
    public int solution(int n, int[] arr){
        int answer = 0, cnt = 1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int tmp = arr[i];
                cnt = 1;
                for(int k=j; k<n; k++){
                    if(tmp < arr[k]){
                        cnt++;
                        tmp = arr[k];
                        System.out.println("j: "+j+", cnt: "+cnt+", tmp: "+tmp);
                    } else {
                        continue;
                    }
                }
                if(answer<cnt) answer=cnt;
            }
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

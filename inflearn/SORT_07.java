import java.util.Arrays;
import java.util.Scanner;

public class SORT_07 {
    public int[][] solution(int n, int[][] arr){
        Arrays.sort(arr, (o1,o2)->{
            return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
        });
        return arr;
    }
    
    public static void main(String[] args) {
        SORT_07 T = new SORT_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for(int[] x: T.solution(n, arr)){
            System.out.println(x[0]+" "+x[1]);
        }
        sc.close();
    }
}

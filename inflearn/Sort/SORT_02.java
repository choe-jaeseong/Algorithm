package Sort;
// 2. 버블 정렬
import java.util.Scanner;

public class SORT_02 {

    public int[] solution(int n, int[] arr){
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        SORT_02 T = new SORT_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(n, arr)){
            System.out.print(x + " ");
        }
        sc.close();
    }
}

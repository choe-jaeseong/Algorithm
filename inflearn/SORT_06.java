import java.util.Scanner;

public class SORT_06 {
    
    public void solution(int n, int[] arr){
        int chulsoo=0, jjak=0, cnt = 0;
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]) {
                if (cnt == 0){
                    chulsoo=i;
                    jjak=i+1;
                    cnt++;
                } else {
                    jjak=i+1;
                    cnt++;
                }
            } else if(cnt == 2) break;
        }
        System.out.println((chulsoo+1) + " " + (jjak+1));
    }

    public static void main(String[] args) {
        SORT_06 T = new SORT_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        T.solution(n, arr);
        sc.close();
    }
}
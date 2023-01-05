import java.util.Scanner;

public class Main{

    public int solution(int[] arr, int[] pt){
        int ans = 0, i = 0;
        int distance = pt[1]-pt[0];
        while (distance > 0){
            if (distance % arr[i] == 0){
                ans++;
                break;
            } else {
                int v = arr[i];
                while (i < pt[1]-1) {
                    i += v;
                    distance -= v;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        int[] pt = new int[2];
        pt[0] = sc.nextInt();
        pt[1] = sc.nextInt();
        System.out.println(T.solution(arr, pt));
    }
}

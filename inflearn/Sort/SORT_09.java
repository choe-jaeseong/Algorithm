package Sort;
import java.util.Arrays;
import java.util.Scanner;

public class SORT_09 {

    public int count(int[] arr, int capacity){
        int cnt = 1, sum = 0;
        for(int x: arr){
            if(sum + x > capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int ans = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum(); //sum은 기본형 int
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid)<=m){
                ans = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SORT_09 T = new SORT_09();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=sc.nextInt();
        System.out.println(T.solution(n, m, arr));
        sc.close();
    }
}

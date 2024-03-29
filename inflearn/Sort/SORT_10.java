package Sort;
import java.util.Arrays;
import java.util.Scanner;

public class SORT_10 {

    public int count(int[] arr, int dist){
        int cnt=1;
        int ep=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr){
        int ans = 0;
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid)>=c){
                ans=mid;
                lt=mid+1;
            }
            else rt=mid-1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        SORT_10 T = new SORT_10();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(T.solution(n, c, arr));
        sc.close();
    }
}

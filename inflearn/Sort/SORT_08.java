package Sort;
// 8. 이분검색
import java.util.Scanner;
import java.util.Arrays;

public class SORT_08 {
    //나의 답 //순차검색
    public int solution1(int n, int x, int[] arr){
        int ans=0;
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(arr[i]==x) return i+1;
        }
        return ans;
    }
    //강의 답 //이분검색
    public int solution2(int n, int x, int[] arr){
        int ans=0;
        Arrays.sort(arr);
        int lt = 0, rt = n-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==x){
                ans = mid+1;
                break;
            }
            if(arr[mid]>x) rt = mid-1;
            else lt = mid+1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        SORT_08 T = new SORT_08();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution2(n,x,arr));
        sc.close();
    }
}

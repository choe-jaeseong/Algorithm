// 4. Least Recently Used
import java.util.Scanner;

public class SORT_04 {

    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];
        for(int i=0; i<n; i++){                 //arr
            int j=0;
            while(j<s && cache[j]!=0 && cache[j]!=arr[i]) j++;
            if(j==s) j--;
            while(j>0) {
                cache[j]=cache[j-1];
                j--;
            }
            cache[0]=arr[i];
        }
        
        return cache;
    }
    
    public static void main(String[] args) {
        SORT_04 T = new SORT_04();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(s, n, arr)){
            System.out.print(x + " ");
        }
        sc.close();
    }
}

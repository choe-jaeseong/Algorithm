import java.util.LinkedList;
import java.util.Scanner;


// 4. Least Recently Used

public class SORT_04 {

    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];
        int i = 0;
        for(int j=0; j<n; j++){
            if()
            while(cache[i] != arr[j]) i++;
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
    }
}

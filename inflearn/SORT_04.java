import java.util.LinkedList;
import java.util.Scanner;

import javax.naming.event.NamingExceptionEvent;

// 4. Least Recently Used

public class SORT_04 {

    public void sort()

    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];
        int cnt = 0;

        

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

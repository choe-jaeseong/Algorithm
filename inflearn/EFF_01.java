//1.두 배열 합치기(two pointers algorithm)
import java.util.*;

public class EFF_01 {

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<n && p2<m){
            if (a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1<n) answer.add(a[p1++]);
        while (p2<m) {
            System.out.println(b[p2]);
            answer.add(b[p2++]);
        }
        return answer;
    }
    
    public static void main(String[] args){
        EFF_01 T = new EFF_01();
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];
        int n1 = sc.nextInt();
        for (int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        for (int i=0; i<n1; i++){
            arr2[i] = sc.nextInt();
        }
        for(int x : T.solution(n1, n2, arr1, arr2)) System.out.print(x + " ");
        sc.close();
        return ;
    }
}

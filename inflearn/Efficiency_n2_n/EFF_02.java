package Efficiency_n2_n;
// 2. 공통원소 구하기
import java.util.*;

public class EFF_02 {
    
    public ArrayList<Integer> solution(int n1, int n2, int[] arr1, int[] arr2){
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int i = 0, j = 0;
        while (i < n1 && j < n2){
            if (arr1[i]==arr2[j]){
                arr.add(arr1[i++]);
                j++;
            } else if (arr1[i] > arr2[j]) j++;
            else i++;
        }
        return arr;
    }

    public static void main(String[] args){
        EFF_02 T = new EFF_02();
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++){
            arr2[i] = sc.nextInt();
        }
        for(int x: T.solution(n1,n2,arr1,arr2)){
            System.out.print(x + " ");
        }
        sc.close();
    }
}

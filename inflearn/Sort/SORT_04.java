package Sort;
// 4. Least Recently Used
// import java.util.ArrayList;
import java.util.Scanner;

public class SORT_04 {

    // ArrayList 로 구현해보기.
    // public ArrayList<Integer> solution3(int s, int n, int[] arr){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<n; j++){
    //             if(list.isEmpty())
    //         }
    //     }
    //     return list;
    // }

    //나의 답
    public int[] solution1(int s, int n, int[] arr){
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

    //강의 답
    public int[] solution2(int s, int n, int[] arr){
        int[] cache = new int[s];
        for(int x: arr){
            int pos=-1;                                     //pos 사용
            for(int i=0; i<s; i++) if(x==cache[i]) pos = i;
            if(pos==-1){
                for(int i=s-1; i>=1; i--){
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
            }
            else{
                for(int i=pos; i>=1; i--){
                    cache[i]=cache[i-1];
                }
                cache[0]=x;
            }
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
        for(int x: T.solution1(s, n, arr)){
            System.out.print(x + " ");
        }
        sc.close();
    }
}

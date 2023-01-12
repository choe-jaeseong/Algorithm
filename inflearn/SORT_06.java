import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SORT_06 {

    //강의 답
    public ArrayList<Integer> solution2(int n, int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for(int i=0; i<n; i++){
            if(arr[i]!=tmp[i]) ans.add(i+1);
        }
        return ans;
    }
    
    //나의 답 //오답
    public void solution1(int n, int[] arr){
        int chulsoo=0, jjak=0, cnt = 0;
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]) {
                if (cnt == 0){
                    chulsoo=i;
                    jjak=i+1;
                    cnt++;
                } else {
                    jjak=i+1;
                    cnt++;
                }
            } else if(cnt == 2) break;
        }
        System.out.println((chulsoo+1) + " " + (jjak+1));
    }

    public static void main(String[] args) {
        SORT_06 T = new SORT_06();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // T.solution1(n, arr);
        for(int x: T.solution2(n, arr)) System.out.print(x + " ");
        sc.close();
    }
}
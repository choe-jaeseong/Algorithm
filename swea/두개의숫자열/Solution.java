package 두개의숫자열;
import java.util.Scanner;

public class Solution {
    private int find_max(int[] arr1, int[] arr2){
        int max = 0;
        int[] longer = arr1.length > arr2.length ? arr1 : arr2;
        int[] shorts = arr1.length < arr2.length ? arr1 : arr2;
        int len = longer.length - shorts.length + 1;

        for(int i = 0; i < len; i++){
            int k = i;
            int sum = 0;
            for (int j = 0; j < shorts.length; j++){
                sum += shorts[j] * longer[k++];
            }
            max = max < sum ? sum : max;
        }

        return max;
    }
    public static void main(String[] args) throws Exception{
        Solution S = new Solution();
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] arr1 = new int[a];
            int[] arr2 = new int[b];
            for (int i = 0; i < a; i++){
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < b; i++){
                arr2[i] = sc.nextInt();
            }
            int answer = S.find_max(arr1, arr2);
            System.out.println("#"+test_case+" "+answer);
		}
        sc.close();
    }
}

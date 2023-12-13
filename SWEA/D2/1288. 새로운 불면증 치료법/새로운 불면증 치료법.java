
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static Set<Integer> set = new HashSet<>();
    private static int[] masking;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int total = (1<<10) - 1;

        for(int t = 1; t <= T; t++){

            int visited = 0;
            int n = Integer.parseInt(br.readLine());

            // 0~9 숫자를 모두 확인할 때까지 반복
            int count = 1;
            for(count=1; ; count++){
                char[] arr = String.valueOf(n * count).toCharArray();
                for(char x : arr){
                    int num = x - '0';
                    visited = visited | (1<<num);
                }

                if(visited == total) break;

            }
            System.out.println("#" + t + " " + count * n);
        }
    }
}
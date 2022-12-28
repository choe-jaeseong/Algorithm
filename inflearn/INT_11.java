// 11. 임시반장 정하기
import java.util.*;

public class INT_11 {

    public void solution(int n, int[][] arr){
        int answer=0, max = 0;
        for (int i = 0; i < n; i++){
            int cnt = 0;
            for (int j = 0; j < n; j++){
                for (int k = 0; k < 5; k++){
                    if (arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max){
                max = cnt;
                answer = i+1;
            }
        }
        System.out.println(answer);
        return ;
    }
    
    public static void main(String[] args){
        INT_11 T = new INT_11();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] st_class = new int[1000][5];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < 5; j++){
                st_class[i][j] = sc.nextInt(); 
            }
        }
        T.solution(n, st_class);
        sc.close();
        return ;
    }
}

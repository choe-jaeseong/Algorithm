package Int;
//12.멘토링
import java.util.*;

public class INT_12 {

    public int solution(int st, int test, int[][] arr){
        int cnt, answer = 0;
        for (int i = 1; i <= st; i++){
            for (int j = 1; j <= st; j++){
                cnt = 0;
                for (int k = 0; k < test; k++){
                    int pi = 0, pj = 0;
                    for (int s = 0; s < st; s++){
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if (pi > pj) cnt++;
                }
                if (cnt == test) answer++;
            }
        }
        return answer;
    }
    
    public static void main(String[] args){
        INT_12 T = new INT_12();
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[11][21];
        int student = sc.nextInt();
        int test = sc.nextInt();
        for (int i = 0; i < test; i++){
            for (int j = 0; j < student; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(student, test, arr));
        sc.close();
        return ;
    }
}

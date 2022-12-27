//7. 점수계산
import java.util.*;

public class INT_07{

    public int solution(int n, int[] result){
        int score=0, reward=0;
        for(int i = 0; i<n; i++){
            if(result[i]==1){
                reward++;
                score+=reward;
            }
            else reward = 0;
        }
        return score;
    }

    public static void main(String[] args){
        INT_07 T = new INT_07();
        Scanner sc = new Scanner(System.in);
        int[] result = new int[100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            result[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, result));
        sc.close();
        return ;
    }
}

/*
import java.util.*;

public class INT_07{

    public int solution(int n, int[] result){
        int score = 0;
        int reward = 0;
        for(int i = 0; i < n; i++){
            if(result[i]==0){
                reward = 0;
                continue;
            } else {
                while(i < n && result[i]==1){
                    reward++;
                    score += reward;
                    i++;
                }
                reward = 0;
            }
        }
        return score;
    }

    public static void main(String[] args){
        INT_07 T = new INT_07();
        Scanner sc = new Scanner(System.in);
        int[] result = new int[100];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            result[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, result));
        sc.close();
        return ;
    }
}
*/
package Sort;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SORT_05 {

    //나의 답: HashMap 과 유사한 방식 (N)
    public void solution1(int N, int[] student){
        //배열
        int[] arr = new int[10000000];
        for(int i=0; i<N; i++){
            arr[student[i]]++;
            if(arr[student[i]]==2){
                System.out.println("D");
                return ;
            } 
        }
        System.out.println("U");
        return ;
    }

    public String solution2(int N, int[] student){
        //해시
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: student){
            map.put(x, map.getOrDefault(x, 0)+1);
            if(map.get(x)==2){
                return "D";
            }
        }
        return "U";
    }

    //강의 답: 정렬(NlogN) , 느리지만 풀 수 있다.
    public String solution3(int N, int[] arr){
        String answer="U";
        Arrays.sort(arr);
        for(int i=0; i<N-1; i++){
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }
    
    public static void main(String[] args) {
        SORT_05 T = new SORT_05();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] student = new int[N];
        for(int i=0; i<N; i++){
            student[i] = sc.nextInt();
        }
        T.solution1(N, student);
        // System.out.println(T.solution1(N, student));
        sc.close();
    }
}

// 5-7 교육과정 설계
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_02 {

    public String solution(String rule, String s){
        Queue<Character> q = new LinkedList<>();
        for(char x : rule.toCharArray()) q.offer(x);
        for(char x : s.toCharArray()){
            if(q.contains(x)) {
                if(x!=q.poll()) return "NO";
            }
        }
        if (!q.isEmpty()) return "NO";
        return "YES";
    }
    
    public static void main(String[] args) {
        Queue_02 T = new Queue_02();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1, s2));
        sc.close();
    }
}

//1. 학급 회장(해쉬)
import java.util.*;

public class HASH_01 {

    //나의 답
    public char solution1(int n, String vote){
        char[] cdd = {'A', 'B', 'C', 'D', 'E'};
        int[] box = new int[5];
        int max = 0, k = 0;
        for (char x: vote.toCharArray()){
            for (int i=0; i<5; i++){
                if(x==cdd[i]){
                    box[i]++;
                    if (max < box[i]){
                        max = box[i];
                        k = i;
                    }
                    break;
                }
            }
        }
        return cdd[k];
    }

    //강의 답
    public char solution2(int n, String s){
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                answer=key;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        HASH_01 T = new HASH_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String vote = sc.next();
        System.out.println(T.solution2(n, vote));
        sc.close();
    }
}

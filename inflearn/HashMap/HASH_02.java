package HashMap;
//2. 아나그램(해쉬)
import java.util.*;

public class HASH_02 {
    
    //나의 답
    public String solution1(String s1, String s2){
        String ans = "YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x: s1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for(char x: s2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }
        for(char x: map1.keySet()){
            if(map1.get(x)!=map2.get(x)) return "NO";
        }
        return ans;
    }
    
    //강의 답
    public String solution2(String s1, String s2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x)==0) return "NO";
            map.put(x, map.get(x)-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        HASH_02 T = new HASH_02();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution1(s1, s2));
        sc.close();
    }
}

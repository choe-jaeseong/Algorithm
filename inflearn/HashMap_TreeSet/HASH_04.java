package HashMap;
//4. 모든 아나그램 찾기
import java.util.*;

public class HASH_04 {
    
    //나의 답 //틀림
    public int solution1(String s, String t){
        int ans = 0;
        char[] sa = s.toCharArray();
        HashMap<Character, Integer> tm = new HashMap<>();
        HashMap<Character, Integer> sm = new HashMap<>();
        for(char x: t.toCharArray()){
            tm.put(x, tm.getOrDefault(x, 0));
        }
        int lt = 0;
        for(int rt = 0; rt < t.length(); rt++){
            sm.put(sa[rt], sm.getOrDefault(sa[rt], 0)+1);
        }
        for(int rt = t.length(); rt < s.length(); rt++){
            System.out.println("size: "+sm.size()+", key: "+sm.keySet()+", ans: "+ans);
            if (sm.equals(tm)) ans++;
            sm.put(sa[lt], sm.get(sa[lt])-1);
            if(sm.get(sa[lt])==0) sm.remove(sa[lt]);
            lt++;
            sm.put(sa[rt], sm.getOrDefault(sa[rt], 0)+1);
        }
        return ans;
    }

    //강의 답
    public int solution2(String a, String b){
        int ans = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char x: b.toCharArray()) bm.put(x, bm.getOrDefault(x,0)+1);
        int L=b.length()-1;
        for(int i=0; i<L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i),0)+1);
        int lt = 0;
        for (int rt = L; rt<a.length(); rt++){
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0)+1);
            // System.out.println("size: "+am.size()+", key: "+am.keySet()+", ans: "+ans);
            if(am.equals(bm)) ans++;
            am.put(a.charAt(lt), am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        HASH_04 T = new HASH_04();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(T.solution2(s, t));
        sc.close();
    }
}

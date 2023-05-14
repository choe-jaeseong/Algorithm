package 완전탐색.불량사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet){
        if(index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }
        for (String id : bans[index]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }
    public int solution(String[] user_id, String[] banned_id){
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    // 나의 풀이
    // static Set<String> set = new HashSet<>();
    // private static boolean isSame(String banned, String user){
    //     if(banned.length() != user.length()) return false;
    //     for(int i = 0; i < banned.length(); i++){
    //         if(banned.charAt(i)=='*') continue;
    //         if(banned.charAt(i) != user.charAt(i)) return false;
    //     }
    //     return true;
    // }
    // private void DFS(String[] banned_id, int idx, String[] user_id, boolean[] isUsed){
    //     if(idx == banned_id.length){
    //         String case1 = "";
    //         for(boolean x : isUsed){
    //             case1 += x;
    //         }
    //         set.add(case1);
    //         return;
    //     }
    //     for(int i = 0; i < user_id.length; i++){
    //         if(isUsed[i]) continue;
    //         if(!isSame(banned_id[idx], user_id[i])) continue;
    //         isUsed[i] = true;
    //         DFS(banned_id, idx + 1, user_id, isUsed);
    //         isUsed[i] = false;
    //     }
    // }
    // public int solution(String[] user_id, String[] banned_id) {
    //     DFS(banned_id, 0, user_id, new boolean[user_id.length]);
    //     return set.size();
    // }
    public static void main(String[] args){
        Solution T = new Solution();
        String[] arr = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bann = {"*rodo", "*rodo", "******"};
        System.out.println(T.solution(arr, bann));
    }
}

package Level0.외계어사전;

public class Solution {
    public int solution(String[] spell, String[] dic) {
        String s = String.join("",spell);
        int[] check = new int[spell.length];

        for(String x : dic){
            System.out.println(x);
            boolean flag = true;
            if(x.length()!=spell.length) continue;
            for(int i=0; i<x.length(); i++){
                int idx = s.indexOf(x.charAt(i));
                if(idx==-1) break;
                else check[idx]++;
            }
            for(int y : check){
                if(y!=1) {
                    flag = false;
                    break;
                }
            }
            if(flag) return 1;
        }
        return 2;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] spell = {"s", "o", "m", "d"};
        String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
        System.out.println(T.solution(spell, dic));
    }
}

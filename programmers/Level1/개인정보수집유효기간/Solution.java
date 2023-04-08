package Level1.개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (map.get(privacy[1]) * 28) <= date) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
    // public int[] solution(String today, String[] terms, String[] privacies) {
    //     String answer = "";
    //     HashMap<String, Integer> period = new HashMap<>();
    //     for(String x : terms){
    //         String[] tmp = x.split(" ");
    //         period.put(tmp[0], Integer.parseInt(tmp[1]));
    //     }
    //     int[] td = getDate(today);
    //     for(int i=0; i<privacies.length; i++){
    //         String x = privacies[i];
    //         int time = period.get(x.charAt(x.length()-1)+"");
    //         int[] pv = getDate(x.substring(0, x.indexOf(" ")));
    //         int diff = (pv[0]*12*28 + pv[1]*28 + pv[2] + time*28-1) - (td[0]*12*28 + td[1]*28 + td[2]);
    //         if(diff<0) answer+=i+1;
    //     }
    //     int[] ans;
    //     if(answer.length()>0){
    //         ans = new int[answer.length()];
    //         for(int i=0; i<ans.length; i++){
    //             ans[i]=answer.charAt(i)-'0';
    //         }
    //     } else return new int[0];
    //     return ans;
    // }
    // private int[] getDate(String s){
    //     int[] arr = new int[3];
    //     int i=0;
    //     for(String x : s.split("[.]")){
    //         arr[i++] = Integer.parseInt(x);
    //     }
    //     return arr;
    // }
    public static void main(String[] args) {
        Solution T = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        for(int x : T.solution(today, terms, privacies)) {
            System.out.println(x);;
        }
    }
}

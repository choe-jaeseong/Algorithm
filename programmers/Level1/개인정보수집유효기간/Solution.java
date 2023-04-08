package Level1.개인정보수집유효기간;

import java.util.HashMap;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String x : terms){
            String[] tmp = x.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        for(String x : map.keySet()) System.out.println(map.get(x));
        int[] td = getDate(today);
        
        return td;
    }
    private int[] getDate(String s){
        int[] arr = new int[3];
        int i=0;
        for(String x : s.split("[.]")){
            arr[i++] = Integer.parseInt(x);
        }
        return arr;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        for(int x : T.solution(today, terms, privacies)) {
            System.out.println(x);;
        }
    }


    //풀이1번
    /*
     * public int[] solution(String today, String[] terms, String[] privacies) {
        String answer = "";
        //데이터 정리
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            String[] s = terms[i].split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        int[] td = initialDate(today);
        int[][] pv = new int[privacies.length][3];
        for(int i=0; i<pv.length; i++){
            String s = privacies[i];
            pv[i] = initialDate(s.substring(0,s.length()-2));
            pv[i][3] = s.charAt(s.length()-1);
        }
        //파기 문서 찾기
        for(int i=0; i<pv.length; i++){
            int period = map.get((char)pv[i][3]+"");
            System.out.println(period);
            pv[i][1]+=period%12;    //month
            if(pv[i][1]>12){
                pv[i][0]++;
                pv[i][1]-=12;
            }
            pv[i][0]+=period/12;    //year
            if(pv[i][2]==1){        //day
                pv[i][1]--;
                pv[i][2]=28;
            }else pv[i][2]--;

            System.out.println(pv[i][0]+"."+pv[i][1]+"."+pv[i][2] + "   "+answer);
            System.out.println(td[0]+" "+td[1]+" "+td[2]);
            //대상 여부 확인
            if(pv[i][0]<td[0]){
                answer+=i+1;
                continue;
            }else if(pv[i][0]>td[0]){
                continue;
            } else { 
                if(pv[i][1]<td[1]){
                    answer+=i+1;
                    continue;
                } else if(pv[i][1]>td[1]){
                    continue;
                } else {
                    if(pv[i][2]<td[2]){
                        answer+=i+1;
                        continue;
                    }else if(pv[i][2]>td[2]){
                        continue;
                    }
                }
            }
        }
        int[] ans = new int[answer.length()];
        for(int i=0; i<answer.length(); i++){
            ans[i]=answer.charAt(i)-'0';
        }
        return ans;
    }
    public int[] initialDate(String today){
        int[] td = new int[4];
        String[] s = today.split("[.]");
        for(int i=0; i<3; i++){
            td[i]=Integer.parseInt(s[i]);
        }
        return td;
    }
     */
}

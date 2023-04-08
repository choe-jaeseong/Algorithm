package Level1.신고결과받기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ch = new int[report.length];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        //report 중복 제거
        Arrays.sort(report);
        for(int i=1; i<report.length; i++){
            if(report[i].equals(report[i-1]))
                ch[i]=1;
        }
        //report 횟수 기록
        for(int i=0; i<report.length; i++){
            if(ch[i]==1) continue;
            String[] tmp = report[i].split(" ");
            map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
        }
        //신고 명단 추출
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        for(Iterator<String> key = arr.iterator(); key.hasNext();){
            String key1 = key.next();
            if(map.get(key1)<k) map.remove(key1);
        }
        for(String x : map.keySet()) System.out.println(x + " " + map.get(x));
        
        //유저별로 신고한 사람 중 신고 명단에 포함된 갯수 count
        for(int i=0; i<report.length; i++){
            if(ch[i]==1) continue;
            String[] tmp = report[i].split(" ");
            if(map.containsKey(tmp[1]))
                ans.put(tmp[0], ans.getOrDefault(tmp[0], 0)+1);
        }
        for(String x : ans.keySet()) System.out.println(x + " " + ans.get(x));
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<answer.length; i++){
            if(ans.get(id_list[i])==null) answer[i]=0;
            else answer[i]=ans.get(id_list[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"muzi", "frodo", "apeach", "neo"};
        String[] arr1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        for(int x : T.solution(arr, arr1, 2)){
            System.out.println(x+ " ");
        }
    }
}

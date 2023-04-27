package 고득점kit.DFS_BFS.여행경로;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean useTickets[];

    public String[] solution(String[][] tickets) {
        useTickets = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    static void dfs(int depth, String now, String path, String[][] tickets){
        if (depth == tickets.length) {
            list.add(path);
            return;
        }
        for (int i = 0; i < useTickets.length; i++) {
            if (!useTickets[i] && now.equals(tickets[i][0])) {
                useTickets[i] = true;
                dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                useTickets[i] = false;
            }
        }
    }
    // 내 풀이 (오답)
    // public String[] solution(String[][] tickets) {
    //     String answer = "";
    //     int[] ch = new int[tickets.length];
    //     PriorityQueue<String> pq = new PriorityQueue<>();
    //     Arrays.sort(tickets, new Comparator<String[]>() {
    //         @Override
    //         public int compare(String[] o1, String[] o2) {
    //             if(o1[0].toString().contentEquals(o2[0].toString()))
    //                 return o1[1].toString().compareTo(o2[1].toString());
    //             else
    //                 return o1[0].toString().compareTo(o2[0].toString());
    //         }			
    //     });
    //     for(int i=0; i<tickets.length; i++){
    //         System.out.println(tickets[i][0]+" "+tickets[i][1]);
    //     }
    //     pq.offer("ICN");
    //     while(!pq.isEmpty()){
    //         String tmp = pq.poll();
    //         answer += tmp + " ";
    //         for(int i=0; i<tickets.length; i++){
    //             if(ch[i]==0 && tickets[i][0].equals(tmp)){
    //                 pq.offer(tickets[i][1]);
    //                 ch[i]=1;
    //             }
    //         }
    //     }
    //     String[] ans = answer.split(" ");
    //     return ans;
    // }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[][] arr = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        for(String x : T.solution(arr))
            System.out.println(x);
    }
}




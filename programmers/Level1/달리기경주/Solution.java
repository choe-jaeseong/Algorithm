package Level1.달리기경주;

import java.util.HashMap;

public class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
        for(String x : callings){
            int idx = map.get(x);
            String tmp = players[idx];
            players[idx]=players[idx-1];
            players[idx-1]=tmp;
            map.put(x,idx-1);
            map.put(players[idx],idx);
        }
        return players;
    }
}

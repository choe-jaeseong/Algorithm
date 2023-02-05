package Level0.옹알이;

import java.util.ArrayList;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        ArrayList<String[]> list= new ArrayList<>();
        for(int i=0; i<babbling.length; i++){
            String[] temp = babbling[i].split("aya|ye|woo|ma");
            list.add(temp);
        }
        for(int i=0; i<list.size(); i++) if(list.get(i).length==0) answer++;
        return answer;
    }
}
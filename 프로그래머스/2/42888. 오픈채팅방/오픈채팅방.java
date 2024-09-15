import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        int count = 0;
        for(String rec : record) {
            String[] r = rec.split(" ");
            if(r[0].equals("Enter")) {
                nicknames.put(r[1], r[2]);
                count++;
            } else if(r[0].equals("Change")) {
                nicknames.put(r[1], r[2]);
            } else {
                count++;
            }
        }
        
        String[] answer = new String[count];
        int idx = 0;
        for(String rec : record) {
            String[] r = rec.split(" ");
            if(r[0].equals("Enter")) {
                answer[idx++] = nicknames.get(r[1]) + "님이 들어왔습니다.";
            } else if(r[0].equals("Leave")) {
                answer[idx++] = nicknames.get(r[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
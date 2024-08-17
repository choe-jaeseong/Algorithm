import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        for(char i='A'; i<='Z'; i++) dic.put(i+"", i - 64);
        
        String[] list = msg.split("");
        StringBuilder now = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        int slot = 0;
        while(idx < list.length) {
            now.append(list[idx]);
            String s = now.toString();
            if(dic.keySet().contains(s)) {
                if(idx == list.length - 1) {
                    result.add(dic.get(s));
                    idx++;
                } else {
                    slot = dic.get(s);
                    idx++;
                    continue;
                }
            } else {
                result.add(slot);
                dic.put(s, dic.keySet().size() + 1);
                now.setLength(0);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

/*
1. 글자 존재 확인 -> 다음 글자 추가 -> 반복하기 
: 없으면 사전 추가 
: 다음 글자로 이동

*/
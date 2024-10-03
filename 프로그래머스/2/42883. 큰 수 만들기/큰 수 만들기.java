import java.util.*;

class Solution {
    public String solution(String number, int k) {
        PriorityQueue<Integer> locs = new PriorityQueue<>();
        for(int i=0; i<number.length() - 1; i++) 
            if(number.charAt(i) < number.charAt(i + 1))
                locs.offer(i);
        
        char[] numArr = number.toCharArray();
        int lastIdx = numArr.length - 1;
        for(int i=0; i<k; i++) {
            if(locs.isEmpty()) {
                numArr[lastIdx--] = ' ';
            } else {
                int idx = locs.poll();
                numArr[idx] = ' ';
                int lp = idx - 1;
                int rp = idx + 1;
                while(lp>=0 && numArr[lp] == ' ') lp--;
                while(rp<=lastIdx && numArr[rp] == ' ') rp++;
                if(lp < 0 || rp > lastIdx) continue;
                if(numArr[lp] < numArr[rp]) locs.add(lp);
            }
        }
        return new String(numArr).replace(" ", "");
    }
}
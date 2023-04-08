package Level1.둘만의암호;

public class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int[] check = new int[26];  //skip 해야하는 알파벳
        char[] arr_s = s.toCharArray();
        for(char t : skip.toCharArray()){
            check[t-'a']++;
        }
        for(int i=0; i<arr_s.length; i++){
            char x = arr_s[i];
            int cnt = 0;
            while(cnt<index){
                System.out.println(cnt + " " + x);
                if(x==122) x = 97;
                else x++;
                if(check[(x-'a')%26]==1) continue;
                else cnt++;
            }
            arr_s[i] = x;
        }
        answer = String.valueOf(arr_s);
        return answer;
    }

    //다른 풀이1
    public String solution1(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        System.out.println(T.solution(s, skip, index));
    }
}

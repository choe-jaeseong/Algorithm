package Level1.가장가까운같은글자;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] visited = new int[26];
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-97;
            if(visited[ch]==0){
                visited[ch] = 1;
                answer[i] = -1;
            } else {
                for(int j=i-1; j>=0; j--){
                    if(s.charAt(j)==s.charAt(i)){
                        System.out.println(s.charAt(i) + ": "+s.charAt(j) + " | "+ i + ", "+ j);
                        answer[i] = i-j;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String s = "banana";
        for(int x : T.solution(s)) System.out.print(x+" ");
    }
}
class Solution {
    
    private static boolean[] visited;
    private static boolean isExist = false;
    private static int answer = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        DFS(0, begin, target, words);
        return answer > words.length ? 0 : answer;
    }
    private static void DFS(int L, String now, String target, String[] words){
        if(L==words.length) return;
        if(now.equals(target)) {
            isExist = true;
            answer = answer > L ? L : answer;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(words.equals(now)) continue;
            if(visited[i]==false && canChange(words, now, i)){
                visited[i]=true;
                DFS(L+1, words[i], target, words);
                visited[i]=false;
            }
        }
    }
    private static boolean canChange(String[] words, String now, int index){
        int count = 0;
        for(int i=0; i<now.length(); i++){
            if(now.charAt(i) == words[index].charAt(i)) count++;
        }
        System.out.println(count);
        boolean result = count==now.length()-1 ? true : false;
        System.out.println(result);
        return result;
    }
}
/*
1. DFS 실행
    - 현재 문자와 알파벳이 하나만 다른 문자를 찾는다.
    - 그 문자로 이동한다. 방문 체크
    - 현재 문자가 target 이면 flag = true, 깊이 저장.
    - 깊이가 현재 주어진 단어 갯수이고 target 이 아니면, 
*/
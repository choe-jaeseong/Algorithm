package Level1.공원산책;

public class Solution {
    static char[] d = {'E','W','S','N'};
    static int[] dx = {0,0,1,-1}; //동서남북
    static int[] dy = {1,-1,0,0};
    public boolean isPossible(int[] answer, String[] park, int n, int i){
        int[] sp = answer.clone();
        for(int j=0; j<n; j++){
            sp[0]+=dx[i];
            sp[1]+=dy[i];
            if(sp[0]>=0 && sp[0]<park.length && sp[1]>=0 && sp[1]<park[0].length() && park[sp[0]].charAt(sp[1])=='O'){
                continue;
            } else return false;
        }
        return true;
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        //시작지점 찾기
        boolean flag = false;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                if(park[i].charAt(j)=='S'){
                    answer[0]=i;
                    answer[1]=j;
                    flag=true;
                }
                if(flag) break;
            }
            if(flag) break;
        }
        //이동시키기
        for(String move : routes){
            for(int i=0; i<4; i++){
                if(d[i]==move.charAt(0)){
                    if(isPossible(answer, park, move.charAt(2)-'0', i)){
                        answer[0]+=dx[i]*(move.charAt(2)-'0');
                        answer[1]+=dy[i]*(move.charAt(2)-'0');
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        for(int x : T.solution(park, routes)){
            System.out.print(x+" ");
        }
    }
}
package Level1.공원산책;

public class Solution {
    static int[] answer = new int[2];
    static String dir = "EWSN";
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[] pk;
    public void DFS(int x, int y, int idx, int L){
        if(!(x>=0 && x<pk.length && y>=0 && y<pk[0].length() && pk[x].charAt(y)!='X'))
            return;
        if(L==0){
            answer[0]=x;
            answer[1]=y;
        }else {
            DFS(x+dx[idx], y+dy[idx], idx, L-1);
        }
    }
    public int[] solution(String[] park, String[] routes) {
        pk = park;
        //1. 시작점 찾기
        for(int i=0; i<park.length; i++){
            int idx = park[i].indexOf("S");
            if(idx!=-1){
                answer[0]=i;
                answer[1]=idx;
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        //2. 종료지점 찾기
        for(String route : routes){
            String[] r = route.split(" ");
            int idx = dir.indexOf(r[0]);
            int L = Integer.parseInt(r[1]);
            DFS(answer[0], answer[1], idx, L);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        for(int x : T.solution(park, routes)){
            System.out.print(x+" ");
        }
    }
}
package Level1.공원산책;

public class Solution {
    public int[] solution(String[] park, String[] routes) {
        String d = "EWSN";
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[] answer = new int[2];
        //1. 시작지점 찾기
        for(int i=0; i<park.length; i++){
            int idx = park[i].indexOf("S");
            if(idx!=-1){
                answer[0]=i;  //x
                answer[1]=idx;//y
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        //2. route 이동시키기
        for(int i=0; i<routes.length; i++){
            String[] route = routes[i].split(" ");
            int idx = d.indexOf(route[0]);
            for(int j=0; j<Integer.parseInt(route[1]); j++){
                int nx = answer[0]+dx[idx];
                int ny = answer[1]+dy[idx];
                System.out.println(j +" "+ nx + " "+ ny);
                if(nx>=0 && nx<park[0].length() && ny>=0 && ny<park.length && park[ny].charAt(nx)=='O'){
                    answer[0]=ny;
                    answer[1]=nx;
                }else break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        for(int x : T.solution(park, routes)){
            System.out.print(x+"     ");
        }
    }
}
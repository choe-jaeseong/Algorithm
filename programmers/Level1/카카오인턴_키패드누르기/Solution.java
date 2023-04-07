package Level1.카카오인턴_키패드누르기;
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Point lh = new Point(3, 0);
        Point rh = new Point(3, 2);
        for(int x : numbers){
            x = x==0 ? 10 : x-1;
            Point p = new Point(x/3, x%3);
            int dis_l = Math.abs(p.x-lh.x)+Math.abs(p.y-lh.y);
            int dis_r = Math.abs(p.x-rh.x)+Math.abs(p.y-rh.y);
            if(x==0||x==3||x==6){
                lh.x = p.x;
                lh.y = p.y;
                answer+="L";
            }else if(x==2||x==5||x==8){
                rh.x = p.x;
                rh.y = p.y;
                answer+="R";
            }else if(dis_l<dis_r){
                lh.x = p.x;
                lh.y = p.y;
                answer+="L";
            }else if(dis_l>dis_r){
                rh.x = p.x;
                rh.y = p.y;
                answer+="R";
            }else{
                if(hand.equals("left")){
                    lh.x = p.x;
                    lh.y = p.y;
                    answer+="L";
                }else{
                    rh.x = p.x;
                    rh.y = p.y;
                    answer+="R";
                }
            }
        }
        return answer;
    }

    //다른 풀이1
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
        {3,1}, //0
        {0,0}, //1
        {0,1}, //2
        {0,2}, //3
        {1,0}, //4
        {1,1}, //5
        {1,2}, //6
        {2,0}, //7
        {2,1}, //8
        {2,2}  //9
};
//초기 위치
int[] leftPos = {3,0};
int[] rightPos = {3,2};
String hand;
public String solution1(int[] numbers, String hand) {
    this.hand = (hand.equals("right")) ? "R" : "L";

    String answer = "";
    for (int num : numbers) {
        String Umji = pushNumber(num);
        answer += Umji;

        if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
        if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
    }
    return answer;
}

//num버튼을 누를 때 어디 손을 사용하는가
private String pushNumber(int num) {
    if(num==1 || num==4 || num==7) return "L";
    if(num==3 || num==6 || num==9) return "R";

    // 2,5,8,0 일때 어디 손가락이 가까운가
    if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
    if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

    //같으면 손잡이
    return this.hand;
}

//해당 위치와 번호 위치의 거리
private int getDist(int[] pos, int num) {
    return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
}

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(T.solution(arr, "right"));
    }
}

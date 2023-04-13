package Level1.바탕화면정리;

public class Solution {
    public int[] solution(String[] wallpaper) {
        int lux=wallpaper.length, luy=wallpaper[0].length(), rdx=0, rdy=0;
        for(int i=0; i<wallpaper.length; i++){
            StringBuilder sb = new StringBuilder();
            String str = sb.append(wallpaper[i]).reverse().toString();
            int idx_l = wallpaper[i].indexOf("#");
            int idx_r = str.indexOf("#");
            if(idx_l==-1) continue;
            else {
                luy=Math.min(luy, idx_l);
                lux=Math.min(lux, i);
                rdy=Math.max(rdy, wallpaper[0].length()-idx_r);
                rdx=Math.max(rdx, i+1);
            }
        }
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
    //다른 풀이1
    public int[] solution1(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i=0; i< wallpaper.length;i++ ){
            for(int j=0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        return new int[]{minX,minY,maxX+1,maxY+1};
    }
    public static void main(String[] args) {
        
    }
}

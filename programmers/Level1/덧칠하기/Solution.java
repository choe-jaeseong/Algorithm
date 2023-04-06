package Level1.덧칠하기;

public class Solution {
    public int solution(int n, int m, int[] section) {
        int[] ch = new int[n+1];
        int cnt = 0;
        for(int i=0; i<section.length; i++){
            if(ch[section[i]]==0){
                for(int j=0; j<m; j++){
                    if(section[i]+j<ch.length)
                        ch[section[i]+j]=1;
                }
                cnt++;
            } else continue;
        }
        return cnt;
    }
    //다른 풀이1
    public int solution1(int n, int m, int[] section) {
        int maxPainted = 0, cntPaint = 0;
        for (int point : section) {
            if (maxPainted <= point) {
                maxPainted = point + m;
                cntPaint++;
            }
        }
        return cntPaint;
    }
}
/*
1. check배열을 만든다.
2. section 시작점부터 롤러 길이 m만큼 체크한다. cnt++
3. 체크되어있는 섹션이면 넘어가고, 아닌 경우 2번을 반복한다.
*/
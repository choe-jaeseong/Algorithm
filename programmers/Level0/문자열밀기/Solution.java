package Level0.문자열밀기;

public class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String tA = A;
        for(int i=0; i<A.length(); i++){
            if(tA.equals(B)) return answer;
            String a = tA.substring(tA.length()-1);
            tA = a + tA.substring(0, tA.length()-1);
            answer++;
        }
        return -1;
    }

    //다른 풀이1
    public int solution1(String A, String B) {
        String tempB = B.repeat(3);
        return tempB.indexOf(A);
    }

    //다른 풀이2
    public int solution2(String A, String B) {
        return (B+B).indexOf(A);
    }
}

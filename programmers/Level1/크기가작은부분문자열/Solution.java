package Level1.크기가작은부분문자열;

//문자열의 길이가 10000까지면 Long 타입으로 변환!
import java.util.ArrayList;
import java.util.stream.LongStream;

public class Solution {
    public ArrayList<Long> getSet(int n, String t){
        ArrayList<Long> arr = new ArrayList<>();
        for(int i=0; i<t.length()-n+1; i++){
            arr.add(Long.parseLong(t.substring(i,i+n)));
        }
        return arr;
    }
    public int solution(String t, String p) {
        int answer = 0;
        long p_Int = Long.parseLong(p);
        for(long x : getSet(p.length( ), t)){
            if(x <= p_Int) answer++;
        }
        return answer;
    }

    //다른 풀이1
    public int solution1(String t, String p) {
        int pLength = p.length();
        long pValue = Long.parseLong(p);
        int answer = 0;
        for (int i = 0; i <= t.length() - pLength; i++) {
            long tValue = Long.parseLong(t.substring(i, i + pLength));
            if (tValue <= pValue)
                answer++;
        }
        return answer;
    }
    //다른 풀이2 (스트림)
    public int solution2(String t, String p) {
        long targetNumber = Long.parseLong(p);
        int targetNumberLength = p.length();

        return (int) LongStream.range(0L, t.length() - targetNumberLength + 1L)
                .mapToObj(i -> t.substring((int) i, (int) i + targetNumberLength))
                .mapToLong(Long::parseLong)
                .filter(number -> number <= targetNumber)
                .count();
    }
}

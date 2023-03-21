package Level1.년2016년;

import java.util.Calendar;
import java.util.Locale;

public class Solution {
    public String getDayName(int a, int b) {
        String answer = "";
        int[] Month_days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] Day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int allDate = 0;
        for(int i=0; i<a-1; i++) allDate += Month_days[i];
        allDate += b;
        answer = Day[allDate%7];
        return answer;
    }

    //다른 풀이1
    public String getDayName1(int month, int day)
    {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                        .setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.getDayName(5, 24));
    }
}

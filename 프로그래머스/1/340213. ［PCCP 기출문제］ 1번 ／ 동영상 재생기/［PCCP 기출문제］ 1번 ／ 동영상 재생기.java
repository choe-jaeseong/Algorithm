class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_len_int = transToSec(video_len);
        int pos_int = transToSec(pos);
        int op_start_int = transToSec(op_start);
        int op_end_int = transToSec(op_end);
        
        if(pos_int >= op_start_int && pos_int <= op_end_int) pos_int = op_end_int;
            
        for(String command : commands) {
            if(command.equals("next")) {
                pos_int += 10;
                if(video_len_int - pos_int < 10) pos_int = video_len_int;
            } else {
                pos_int -= 10;
                if(pos_int < 10) pos_int = 0;
            }
            if(pos_int >= op_start_int && pos_int <= op_end_int) pos_int = op_end_int;
        }
            
        String minutes = (pos_int / 60 < 10 ? "0" + (pos_int / 60) : pos_int / 60) + "";
        String seconds = (pos_int % 60 < 10 ? "0" + (pos_int % 60) : pos_int % 60) + "";
        return minutes + ":" + seconds;
    }
    private static int transToSec(String s) {
        int seconds = 0;
        String[] splits = s.split(":");
        seconds += Integer.parseInt(splits[0]) * 60;
        seconds += Integer.parseInt(splits[1]);
        return seconds;
    }
}
package Level0.로그인성공;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] x : db){
            if(x[0].equals(id_pw[0])){
                if(x[1].equals(id_pw[1]))
                    return "login";
                else
                    return "wrong pw";
            }
        }
        return "fail";
    }

    //다른 풀이1
    public String solution1(String[] idPw, String[][] db) {
        return getDb(db).get(idPw[0]) != null ? getDb(db).get(idPw[0]).equals(idPw[1]) ? "login" : "wrong pw" : "fail";
    }

    private Map<String, String> getDb(String[][] db) {
        Map<String, String> map = new HashMap<>();

        for (String[] array : db) {
            map.put(array[0], array[1]);
        }
        return map;
    }
}

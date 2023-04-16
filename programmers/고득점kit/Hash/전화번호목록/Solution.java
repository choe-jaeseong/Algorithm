package 고득점kit.Hash.전화번호목록;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    //나의 답 (효율성 테스트 3, 4번 실패)
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            for(int j=i+1; j<phone_book.length; j++){
                for(int k=0; k<phone_book[i].length(); k++){
                    if(phone_book[i].charAt(k)!=phone_book[j].charAt(k)){
                        answer=true;
                        break;
                    }else answer=false;
                }
                if(!answer) return answer;
            }
        }
        return answer;
    }

    //정답 1(HashSet 사용)
    public boolean solution1(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
    //정답 2(HashSet + TreeSet 사용)
    public boolean solution2(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Set<Integer> lengths = new TreeSet();
        for (String phone : phone_book) {
            set.add(phone);
            lengths.add(phone.length());
        }
        for (String phone : phone_book) {
            for (int i : lengths) {
                if (i >= phone.length()) {
                    break;
                }
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
    //정답 3(선택정렬 느낌. startWith 메서드)
    public boolean solution3(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
             for(int j=i+1; j<phoneBook.length; j++) {
                 if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                 if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
             }
         }
         return true;
     }
}

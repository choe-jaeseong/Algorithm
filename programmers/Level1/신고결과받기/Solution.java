package Level1.신고결과받기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ch = new int[report.length];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        //report 중복 제거
        Arrays.sort(report);
        for(int i=1; i<report.length; i++){
            if(report[i].equals(report[i-1]))
                ch[i]=1;
        }
        //report 횟수 기록
        for(int i=0; i<report.length; i++){
            if(ch[i]==1) continue;
            String[] tmp = report[i].split(" ");
            map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
        }
        //신고 명단 추출
        ArrayList<String> arr = new ArrayList<>(map.keySet());
        for(Iterator<String> key = arr.iterator(); key.hasNext();){
            String key1 = key.next();
            if(map.get(key1)<k) map.remove(key1);
        }
        //유저별로 신고한 사람 중 신고 명단에 포함된 갯수 count
        for(int i=0; i<report.length; i++){
            if(ch[i]==1) continue;
            String[] tmp = report[i].split(" ");
            if(map.containsKey(tmp[1]))
                ans.put(tmp[0], ans.getOrDefault(tmp[0], 0)+1);
        }
        //유저가 받은 메일 수 배열 생성
        int[] answer = new int[id_list.length];
        for(int i=0; i<answer.length; i++){
            if(ans.get(id_list[i])==null) answer[i]=0;
            else answer[i]=ans.get(id_list[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"muzi", "frodo", "apeach", "neo"};
        String[] arr1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        for(int x : T.solution(arr, arr1, 2)){
            System.out.println(x+ " ");
        }
    }


    //다른 풀이1
    public int[] solution1(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    //다른 풀이2
    public int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }
        for(String re : report){
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        for(User user : users){
            for(String nameReport : user.reportList){
                if(suspendedList.get(nameReport) != null){
                    answer[idIdx.get(user.name)]++;
                }

            }
        }
        return answer;
    }
}
class User{
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}
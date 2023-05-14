package 이진탐색.순위검색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/*
 * 1. 전처리를 위해 매개변수 info 를 사용하여 조건별 리스트를 생성하는 buildScoresMap 메서드 작성
 *      scoreMap => 문자열 검색조건 key , 해당 검색 조건에 들어 있는 점수 리스트 value
 * 2. 
 */
public class Solution {
    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for(String s : info){
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            // scoresMap에 추가
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()){
            Collections.sort(list);
        }

        return scoresMap;
    }

    //모든 조건의 경우의 수를 구하기
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action){
        if(index == tokens.length - 1){
            //prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }
    
    private int binarySearch(int score, List<Integer> scores){
        //이진 탐색으로 인덱스 찾기
        int start = 0;
        int end = scores.size() - 1;

        while(end > start) {
            //중간 값에 따라 범위 좁히기
            int mid = (start + end) / 2;

            if(scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if(scores.get(start) < score){
            return scores.size();
        }
        return start;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        //scoresMap을 이용하여 query에 맞는 지원자 수 세기
        String[] tokens = query.split(" (and )?"); //정규표현식
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        
        if(!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoresMap.get(key));
    }
    public int[] solution(String[] info, String[] query){
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);
        
        int[] answer = new int[query.length];
        for(int i = 0; i < answer.length; i++){
            //정답 구하기
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
        //배열 answer 선언 시,
        //return Stream.of(query).mapToInt(q -> count(q, scoresMap)).toArray();
    }
}

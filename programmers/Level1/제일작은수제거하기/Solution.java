package Level1.제일작은수제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length==1){
            answer = new int[]{-1};
        } else {
            answer = new int[arr.length-1];
            int[] arr2 = arr.clone();
            Arrays.sort(arr2);
            int k=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]==arr2[0]) continue;
                else answer[k++]=arr[i];
            }
        }
        return answer;
    }

    //다른 풀이1 (Stream이 가독성이 좋긴한데 속도문제가..for문보다 느림..버전 제한 있는건좀 조심스럽지요)
    public int[] solution1(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
    /* 다른 풀이2
     * remove()는 제너릭 타입을 반환하거나 boolean 타입을 반환할 수 있는데, 넣으신 minimum은 인덱스가 아니라 값일 텐데 어떻게 넣었는지 궁금하네요. Collections.min()도 값을 반환할텐데 말이죠
     */
    public int[] solution2(int[] arr) {
        if (arr.length == 1) {
              arr[0] = -1;
              return arr;
          } else {
              ArrayList<Integer> arrayList = new ArrayList<Integer>();
              for (int a : arr) {
                  arrayList.add(a);
              }
              Integer minimum = Collections.min(arrayList);
              arrayList.remove(minimum);
              int[] resultArray = new int[arr.length - 1];
              for (int i = 0; i < arrayList.size(); ++i) {
                  resultArray[i] = arrayList.get(i);
              }
              return resultArray;
          }
    }
    // 다른 풀이3
    public int[] solution3(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Arrays.sort(arr);
        list.remove(list.indexOf(arr[0]));
        if (list.size() <= 0) return new int[]{-1};
        return list.stream().mapToInt(i->i).toArray();
    }
    //다른 풀이4
    public int[] solution4(int[] arr) {
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
  
        int[] answer = new int[arr.length-1];
        int minIndex=0;
  
        for(int i=0;i<arr.length;i++){
            if(arr[minIndex]>arr[i]){
                minIndex = i;
            }
        }
        for(int i=minIndex+1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}

package Book.이진탐색;

/* 이진 탐색 : 분할정복을 이용한 효율적인 탐색법
 * 
 * 1. 범위 찾기
 * 2. 검사 진행하기
 * 3. 중간 값 비교하기
 */
public class base {
    private static int binarySearch(int[] arr, int target){
        int start = 0;  //incursive
        int end = 0;    //excursive

        while (end - start > 0){        //end > start
            int mid = (start + end) / 2;
            int value = arr[mid];

            if (value == target){
                return mid;
            } else if (value > target){
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

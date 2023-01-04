//26215. 눈 치우기
//Integer[] 사용
import java.util.*;

public class main_26215 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i=0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        int cnt = 0;
        while (arr[0]>0){
            arr[0]--;
            if(n>1)
                arr[1]--;
            Arrays.sort(arr, Collections.reverseOrder());
            cnt++;
        }
        if (cnt > 1440)
            System.out.println(-1);
        else
            System.out.println(cnt);
        sc.close();
    }
}

// ArrayList 사용
// import java.util.*;

// public class main_26215 {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         ArrayList<Integer> list = new ArrayList<>();
//         for (int i=0; i < n; i++){
//             list.add(sc.nextInt());
//         }
//         Collections.sort(list, Collections.reverseOrder());

//         int cnt = 0;
//         while (list.get(0)>0){
//             list.set(0, list.get(0)-1);
//             if(list.size()>1)
//                 list.set(1, list.get(1)-1);
//             Collections.sort(list, Collections.reverseOrder());
//             cnt++;
//         }
//         if (cnt > 1440)
//             System.out.println(-1);
//         else
//             System.out.println(cnt);
//         sc.close();
//     }
// }
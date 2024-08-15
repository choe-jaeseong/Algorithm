class Solution {
    
    public int solution(String[][] book_time) {
        int[] time = new int[10000];
        for(String[] book : book_time) {
            check(time, book);
        }
        int answer = 0;
        for(int t : time) answer = Math.max(answer, t);
        return answer;
    }
    private static void check(int[] time, String[] book) {
        int start = Integer.parseInt(book[0].replace(":", ""));
        int end = Integer.parseInt(book[1].replace(":", "")) + 10;
        if(end % 100 > 60) end += 40;
        for(int i=start; i<end; i++) {
            time[i]++;
        }
    }
}

// import java.util.*;

// class Solution {
//     public int solution(String[][] book_time) {
//         int[][] books = makeList(book_time);
//         Arrays.sort(books, (o1, o2) -> {
//             if(o1[0] == o2[0]) {
//                 return o1[1] - o2[1];
//             }
//             return o1[0] - o2[0];
//         });
        
//         // for(int[] book : books) {
//         //     for(int b : book) System.out.print(b + " ");
//         //     System.out.println();
//         // }
//         int[] time = new int[10000];
//         for(int[] book : books) {
//             for(int i=book[0])
//         }
//         return 0;
//     }
//     private static int[][] makeList(String[][] book_time) {
//         int[][] result = new int[book_time.length][2];
//         for(int i=0; i<book_time.length; i++) {
//             int[] book = new int[2];
//             book[0] = Integer.parseInt(book_time[i][0].replace(":",""));
//             book[1] = Integer.parseInt(book_time[i][1].replace(":",""));
//             result[i] = book;
//         }
//         return result;
//     }
// }
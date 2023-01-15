// 7. 좌표정렬
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

//강의 답
class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class SORT_07 {

    //나의 답
    public int[][] solution1(int n, int[][] arr){
        Arrays.sort(arr, (o1,o2)->{
            return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
        });
        return arr;
    }
    
    public static void main(String[] args) {
        SORT_07 T = new SORT_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //나의 답
        // int[][] arr = new int[n][2];
        // for(int i=0; i<n; i++){
        //     arr[i][0] = sc.nextInt();
        //     arr[i][1] = sc.nextInt();
        // }
        // for(int[] x: T.solution1(n, arr)){
        //     System.out.println(x[0]+" "+x[1]);
        // }

        //강의 답
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        // for(Point o: arr) System.out.println(o.x + " " o.y);

        sc.close();
    }
}

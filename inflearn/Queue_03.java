// 8. 응급실
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Queue_03 {

    public int solution(int n, int m, int[] arr){
        int ans = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.add(new Person(i, arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp = Q.poll();
            for(Person x : Q){
                if(x.priority>tmp.priority){
                    Q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                ans++;
                if(tmp.id==m) return ans;
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        Queue_03 T = new Queue_03();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = sc.nextInt();
        }
        System.out.println(T.solution(n,m, arr));
        sc.close();
    }
}

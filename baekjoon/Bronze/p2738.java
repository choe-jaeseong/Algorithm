import java.util.Scanner;

public class p2738{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr1[n][m]=sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr2[n][m]=sc.nextInt();
                System.out.print(arr1[n][m]+arr2[n][m]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] strokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		
		char[] arr = new char[s1.length()*2];
		for(int i=0; i<arr.length; i+=2) arr[i] = s1.charAt(i/2);
		for(int i=1; i<arr.length; i+=2) arr[i] = s2.charAt(i/2);
		
		//문자를 획수로 변환
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = strokes[arr[i]-65];
		}
		making(arr2, new int[arr2.length-1]);
	}
	private static void making(int[] arr, int[] newArr) {
		if(arr.length==2) {
			System.out.println(arr[0] + "" + arr[1]);
			return;
		}
		for (int i = 0; i < newArr.length; i++)
			newArr[i] = (arr[i] + arr[i+1]) % 10;
		making(newArr, new int[newArr.length-1]);

	}
}

/*
 * dp 접근
 * making(숫자 배열 넣기, 왼쪽 배열보다 1 작은 배열 만들기)
 * 	1. 
*/

import java.util.Scanner;

/*
 * 배열 [a, b, c, d]를 입력하면 배열[bcd, acd, abd, abc]를 출력하는 코드를 작성하시오.

(단, 나눗셈 사용 금지)

입출력되는 배열은 어떤 형식이든 상관없습니다.

입력 예시

2, 6, 4, 7
출력 예시

168, 56, 84, 48
 */
public class Main {

	public static void main(String[] args) {
		int arr[] = new int[4];
		int result[] = new int[4];
		Scanner s= new Scanner(System.in);
		
		for(int i=0; i<4; i++) {
			arr[i] = s.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			result[i] = 1;
			for(int j=0; j<4; j++) {
				if(i!=j)
					result[i]*=arr[j];
			}
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
		
		s.close();
	}

}

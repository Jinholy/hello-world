import java.util.Scanner;

/*
 * �迭 [a, b, c, d]�� �Է��ϸ� �迭[bcd, acd, abd, abc]�� ����ϴ� �ڵ带 �ۼ��Ͻÿ�.

(��, ������ ��� ����)

����µǴ� �迭�� � �����̵� ��������ϴ�.

�Է� ����

2, 6, 4, 7
��� ����

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

/*
 * ���� Ư���� �ǹ̸� �ο��ϴ� ���� �������Ƕ�� �Ѵ�.

����� � ����� �����ϱ� ���� �������� Ŭ���� �����Ѵ�.
�ٸ� �� Ŭ���� ���� ���ؼ��� � ���� �Է¹ް� �� ���� � ������ �˷��ִ� ���α׷��� �ۼ��ؾ� �Ѵ�.
����) ���� ���� n�� �Է¹ް� �� ���� ���׼����� ���������� ���������� ����ϴ� ���α׷��� �ۼ��Ͻʽÿ�.
��)
6
20
15
��)
�������Դϴ�
���׼��Դϴ�
�������Դϴ�
����� : � ���� �ڱ��ڽ��� ������ ��� (�� - 20�� ������� 1,2,4,5,10)
������ : ��������� ���� �ڱ� �ڽ��� ��
���׼� : ��������� ���� �ڱ� �ڽź��� ū ��
������ : ��������� ���� �ڱ� �ڽź��� ���� ��
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> yaksuList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		
		makeList(input);
		verify(input);
		
		for(int i : yaksuList) {
			System.out.println(i);
		}
		s.close();
	}
	
	public static void makeList(int n) {
		for(int i=1; i<n; i++) {
			if(n%i==0) {
				yaksuList.add(i);
			}
		}
	}
	
	static public void verify(int input) {
		int val = 0;
		for(int i : yaksuList) {
			val+=i;
		}
		System.out.println("input: " + input + "/ sum: "+ val);
		if(val==input) {
			System.out.println("������");
		}else if(val>input) {
			System.out.println("���׼�");
		}else {
			System.out.println("������");
		}
	}

}

import java.util.Scanner;

/*
 ����� �౸�����ٰ� �츮���󼱼����Ǹ����� �˰�;���

�׷��� �˻����ؼ� �޸��忡 ���µ� Ű���尡 ���׸��ϰ� ����������

�ڲ� ���ڰ��ƴ� ���ڸ� �����Է��ع�����

ex:����x : 1627000000 > ��x�� : 1w627r00o00p00 �� (Ư����������)

����� ������������ ���ξȵǴ°Ϳ�

�ʹ�ȭ������ �ڽ��̼������Է��ϸ� ���ڿ��� �� '����' ���ڸ� ��ȯ�ϴ� �ڵ带 �����;��Ѵ�

ȭ���� ���츦���� �ڵ带 ������!
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String result = "";
		
		for(int i=0; i<str.length(); i++) {
			if(48<str.charAt(i) && str.charAt(i)<58) {
				result+=str.charAt(i);
			}
		}
		System.out.println(result);
	}

}

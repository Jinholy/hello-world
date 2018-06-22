/*
1900�� 1�� 1���� �������̴�.
4��, 6��, 9��, 11���� 30�ϱ��� �ְ�, 1��, 3��, 5��, 7��, 8��, 10��, 12���� 31�ϱ��� �ִ�.
2���� 28��������, ���⿡�� 29�ϱ��� �ִ�.
������ ������ 4�� ������ �������� �ظ� ���Ѵ�. ������ 400���� ������ �������� �ʴ� �� 100��°�� ������ �ƴϸ�
400���� ������ �������� �����̴�.
20���� (1900�� 1�� 1�� ~ 1999�� 12�� 31��) ����, �ſ� 1���� �Ͽ����� ���� �� �� ���Դϱ�?
 */
import java.util.Calendar;
public class Main {

	public static void main(String[] args) {
		Calendar c= Calendar.getInstance();
		
		c.set(1999, 12, 30, 0, 0, 0);
		long after = c.getTimeInMillis();
		c.set(1900, 0, 1, 1, 1, 1);
		int result = 0;
		
		while(c.getTimeInMillis() < after) {
			if(c.get(Calendar.DAY_OF_WEEK) == 1) {
				result++;
			}
			c.add(Calendar.MONTH, 1);
		}

		System.out.println(result);
	}

}

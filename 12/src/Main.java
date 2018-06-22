/*
1900년 1월 1일은 월요일이다.
4월, 6월, 9월, 11월은 30일까지 있고, 1월, 3월, 5월, 7월, 8월, 10월, 12월은 31일까지 있다.
2월은 28일이지만, 윤년에는 29일까지 있다.
윤년은 연도를 4로 나누어 떨어지는 해를 말한다. 하지만 400으로 나누어 떨어지지 않는 매 100년째는 윤년이 아니며
400으로 나누어 떨어지면 윤년이다.
20세기 (1900년 1월 1일 ~ 1999년 12월 31일) 에서, 매월 1일이 일요일인 경우는 총 몇 번입니까?
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

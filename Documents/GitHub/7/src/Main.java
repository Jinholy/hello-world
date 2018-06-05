import java.util.Scanner;

/*
 철이는 아스키코드에 대해 공부하고있었습니다.

하지만 기억력이 좋지않아 순서를 잊어먹게되는탓에 프로그램을 하나 만들어두려합니다.

문자를 입력받으면 그 문자에 해당하는 아스키코드를 출력하는 코드를 작성해주세요.

출력조건

a는 아스키코드로 97입니다.

d는 아스키코드로 100입니다.

A는 아스키코드로 65입니다.
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char input = s.nextLine().charAt(0);
		int result = input;
		
		System.out.println(input + "는 아스키 코드로" + result + "입니다.");
		
		
		
		s.close();
	}

}

import java.util.Scanner;

/*
 끝없이 이어지는 무한소수 중 특정한 부분이 계속 반복되는 소수를 순환소수라고 하며, 반복되는 부분을 순환마디라고 한다.

모든 순환소수는 아래처럼 분수로 표현이 가능하다.

x = 0.5555....
10x = 5.55555....
9x(10x-x) = 5.5555... - 0.55555... = 5
x = 5/9
순환소수와 순환마디를 입력하면 기약분수로 표현한 값을 출력하는 프로그램을 작성하시오.

예시:

첫 번째 입력은 첫 번째 순환마디가 끝나는 부분까지의 순환소수, 
두 번째 입력은 순환마디

0.5     →    5/9
5

1.49    →    3/2
9

 */
public class Main {

	public static void main(String[] args) {
		String input = "";
		Scanner s = new Scanner(System.in);
		
		input = s.nextLine();
		String 	val[] 	= input.split("\\.");
		int upperDot 	= Integer.parseInt(val[0]);				//소수점위
		int lastInt 	= Integer.parseInt(val[1])%10;			//소수점아래  마지막수
		int remainInt	= Integer.parseInt(val[1]) - lastInt;	//소수점아래 마지막수 제외숫자
		remainInt/=10;
		
		int denominator1 = 1;		//소수점아래 마지막숫자를 제외한 남은숫자분모
		int denominator2 = 1;		//마지막숫자분모
		
		for(int i=0; i< val[1].length()-1; i++) {
			denominator1*=10;
		}
		
		denominator2 = denominator1*9;
		
		/*
		System.out.println(val[0] + "."+ remainInt + " " + lastInt);
		System.out.println(denominator1 + " " + denominator2);
		*/
		
		int denominator = denominator1*denominator2;
		int numerator 	= upperDot*denominator + denominator1*lastInt + denominator2*remainInt;
		int gys			= getGYS(numerator, denominator);
		
		if(denominator/gys == numerator/gys)
			System.out.println("result : 1");
		else if(denominator/gys !=1)
			System.out.println("result : " + numerator/gys + "/" + denominator/gys);
		else
			System.out.println("result : " + numerator/gys);
			
		s.close();
	}
	
	public static int getGYS(int a, int b) {	//최대 공약수구함
		int result=1;
		int x = a>b?a:b;
		int y = a>b?b:a;
		
		for(int i=1; i<x; i++) {
			if(x%i==0 && y%i ==0)
				result = i;
		}
		
		return result;
	}
}

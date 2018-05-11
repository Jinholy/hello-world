import java.util.Scanner;

/*
 ������ �̾����� ���ѼҼ� �� Ư���� �κ��� ��� �ݺ��Ǵ� �Ҽ��� ��ȯ�Ҽ���� �ϸ�, �ݺ��Ǵ� �κ��� ��ȯ������ �Ѵ�.

��� ��ȯ�Ҽ��� �Ʒ�ó�� �м��� ǥ���� �����ϴ�.

x = 0.5555....
10x = 5.55555....
9x(10x-x) = 5.5555... - 0.55555... = 5
x = 5/9
��ȯ�Ҽ��� ��ȯ���� �Է��ϸ� ���м��� ǥ���� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

����:

ù ��° �Է��� ù ��° ��ȯ���� ������ �κб����� ��ȯ�Ҽ�, 
�� ��° �Է��� ��ȯ����

0.5     ��    5/9
5

1.49    ��    3/2
9

 */
public class Main {

	public static void main(String[] args) {
		String input = "";
		Scanner s = new Scanner(System.in);
		
		input = s.nextLine();
		String 	val[] 	= input.split("\\.");
		int upperDot 	= Integer.parseInt(val[0]);				//�Ҽ�����
		int lastInt 	= Integer.parseInt(val[1])%10;			//�Ҽ����Ʒ�  ��������
		int remainInt	= Integer.parseInt(val[1]) - lastInt;	//�Ҽ����Ʒ� �������� ���ܼ���
		remainInt/=10;
		
		int denominator1 = 1;		//�Ҽ����Ʒ� ���������ڸ� ������ �������ںи�
		int denominator2 = 1;		//���������ںи�
		
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
	
	public static int getGYS(int a, int b) {	//�ִ� ���������
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

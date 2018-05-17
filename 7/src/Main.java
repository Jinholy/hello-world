import java.util.Scanner;

/*
 ���̽�� ���� ��� ���α׷��� ���� Pothole_case �� �� ��ȣ�ϴ� ����� �մϴ�.
Example:
codingDojang --> coding_dojang
numGoat30 --> num_goat_3_0

�� ����� ���� CameleCase�� Pothole_case �� �ٲٴ� �Լ��� ������!
  
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input =s.nextLine();
		
		System.out.println(changeToPotholeCase(input));
		
		
		s.close();
	}
	
	public static String changeToPotholeCase(String input) {
		String result = "";
		char[] cArr = input.toCharArray();
		
		for(int i=0; i< cArr.length; i++) {
			if(Character.isUpperCase(cArr[i])||Character.isDigit(cArr[i])){		//�빮�ڸ�
				result = result + "_" + Character.toLowerCase(cArr[i]);
			}else {
				result+=cArr[i];
			}
		}
		
		return result;
	}

}

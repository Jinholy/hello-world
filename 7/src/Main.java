import java.util.Scanner;

/*
 파이썬과 같은 몇몇 프로그래밍 언어는 Pothole_case 를 더 선호하는 언어라고 합니다.
Example:
codingDojang --> coding_dojang
numGoat30 --> num_goat_3_0

위 보기와 같이 CameleCase를 Pothole_case 로 바꾸는 함수를 만들어요!
  
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
			if(Character.isUpperCase(cArr[i])||Character.isDigit(cArr[i])){		//대문자면
				result = result + "_" + Character.toLowerCase(cArr[i]);
			}else {
				result+=cArr[i];
			}
		}
		
		return result;
	}

}

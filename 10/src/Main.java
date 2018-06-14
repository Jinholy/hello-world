/*
 * 수의 특별한 의미를 부여하는 것을 수비주의라고 한다.

당신은 어떤 사건을 수사하기 위해 수비주의 클럽에 들어가야한다.
다만 이 클럽에 들어가기 위해서는 어떤 수를 입력받고 그 수가 어떤 수인지 알려주는 프로그램을 작성해야 한다.
문제) 양의 정수 n을 입력받고 그 수가 과잉수인지 완전수인지 부족수인지 출력하는 프로그램을 작성하십시오.
예)
6
20
15
답)
완전수입니다
과잉수입니다
부족수입니다
진약수 : 어떤 수의 자기자신을 제외한 약수 (예 - 20의 진약수는 1,2,4,5,10)
완전수 : 진약수들의 합이 자기 자신인 수
과잉수 : 진약수들의 합이 자기 자신보다 큰 수
부족수 : 진약수들의 합이 자기 자신보다 작은 수
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
			System.out.println("완전수");
		}else if(val>input) {
			System.out.println("과잉수");
		}else {
			System.out.println("부족수");
		}
	}

}

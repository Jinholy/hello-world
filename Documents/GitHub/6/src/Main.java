/*
 * 
 스도쿠를 풀어버리자.

입력설명

첫번째줄에 첫번째 줄에 있는 숫자가 들어간다.
둘번째줄에 두번째 줄에 있는 숫자가 들어간다.
n번째줄에 n번째 줄에 있는 숫자가 들어간다.

출력설명
해답을 출력한다.
 */

public class Main {

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		
		String plate = 
				  "005300000\n"
				+ "800000020\n"
				+ "070010500\n"
				+ "400005300\n"
				+ "010070006\n"
				+ "003200080\n"
				+ "060500009\n"
				+ "004000030\n"
				+ "000009700";
				
		
		String answer = "145327698\n"
				+ "839654127\n"
				+ "672918543\n"
				+ "496185372\n"
				+ "218473956\n"
				+ "753296481\n"
				+ "367542819\n"
				+ "984761235\n"
				+ "521839764";
				
		
		s.setPlate(plate);
//		s.printPlate();
		s.solve();
		s.printPlate();
		s.setCandidates();
		s.printCandidates();
		/*
		System.out.println(s.checkCol(0));
		System.out.println(s.checkRow(8));
		System.out.println(s.checkBlock(0,0));
		*/
	}

}

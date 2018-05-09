import java.util.ArrayList;

public class Try {
	private int[] shot;
	private int strikeC;
	private int ballC;
	private ArrayList<Integer> cases;
	
	
	public Try(int shot, int strikeC, int ballC) {
		this.shot = setShot(shot);
		this.strikeC = strikeC;
		this.ballC = ballC;
		cases = new ArrayList<Integer>();
		makeCases();
	}
	
	public ArrayList<Integer> getCases(){
		return cases;
	}
/*
 가능한 스트/볼 카운트 경우의수
 0/0
 0/1 : *-- -*- --* 
 0/2 : **- *-* -** 
 0/3 : ***
 1/0 : &-- -&- --&
 2/0 : &&- -&& &-&
 3/0 : &&&
 1/1 : 
 1/2
 2/0
 2/1
 */
	private void makeCases() {
		ArrayList<Integer> sc = new ArrayList<Integer>();
		ArrayList<Integer> bc = new ArrayList<Integer>();

		switch(strikeC) {
		case 0:
			break;
		case 1:
			sc = getStrike1Case();
			break;
		case 2:
			sc = getStrike2Case();
			break;
		case 3:
			sc.add(shot[0]*100+shot[1]*10+shot[2]);
			break;
		}
		
		switch(ballC) {
		case 0:
			for(int i=1; i<10; i++) {
				for(int j=1; j<10; j++) {
					for(int k=1; k<10; k++) {
						if(check(i,j,k))
							bc.add(i);	
					}
				}
			}
			break;
		case 1:
			bc = getBall1Case();
			break;
		case 2:
			bc = getBall2Case();
			break;
		case 3:
			bc = getBall3Case();
			break;
		}
		
		sc.retainAll(bc);
		cases.addAll(sc);
	}
	
	private ArrayList<Integer> getStrike1Case(){
		ArrayList<Integer> sc = new ArrayList<Integer>();
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[0]))
					sc.add(shot[0]*100+i*10+j);
			}
		}			

		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[1]))
					sc.add(i*100+shot[1]*10+j);
			}
		}
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[2]))
					sc.add(i*100+j*10+shot[2]);
			}
		}			
		
		return sc;
	}
	
	private ArrayList<Integer> getStrike2Case(){
		ArrayList<Integer> sc = new ArrayList<Integer>();
		
		for(int i=1; i<10; i++) {
			if(check(i,shot[0],shot[1]))
				sc.add(shot[0]*100+shot[1]*10+i);
		}

		for(int i=1; i<10; i++) {
			if(check(i,shot[0],shot[2]))
				sc.add(shot[0]*100+i*10+shot[2]);
		}

		for(int i=1; i<10; i++) {
			if(check(i,shot[1],shot[2]))
				sc.add(i*100+shot[1]*10+shot[2]);
		}
		
		return sc;
	}
	
	private ArrayList<Integer> getBall1Case(){
		ArrayList<Integer> bc = new ArrayList<Integer>();
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[0])) {
					bc.add(i*100+shot[0]*10+j);
					bc.add(i*100+j*10+shot[0]);					
				}
			}
		}
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[1])) {
					bc.add(shot[1]*100+i*10+j);
					bc.add(i*100+j*10+shot[1]);					
				}
			}
		}
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(check(i,j,shot[2])) {
					bc.add(i*100+shot[2]*10+j);
					bc.add(shot[2]*100+j*10+i);					
				}
			}
		}
		
		return bc;
	}
	
	private ArrayList<Integer> getBall2Case(){
		ArrayList<Integer> bc = new ArrayList<Integer>();
		
		/*
		 * 1 2번째에 있는 숫자가 ball일경우
		 * 1과 2가 그 자리에있는 수 : 123 132 321은 정답이 될 수 없음
		 * 213 231 312만 가능
		 */
		for(int i =1; i<10 ; i++) {			
			if(check(i,shot[0],shot[1])) {
				bc.add(shot[1]*100+shot[0]*10+i);
				bc.add(shot[1]*100+i*10+shot[0]);
				bc.add(shot[2]*100+i*10+shot[0]);
			}
		}
		// 2,3이 ball일때  132, 231, 312
		for(int i =1; i<10 ; i++) {			
			if(check(i,shot[1],shot[2])) {
				bc.add(i*100+shot[2]*10+shot[1]);
				bc.add(shot[1]*100+shot[2]*10+i);
				bc.add(shot[2]*100+i*10+shot[1]);
			}
		}
		// 3,1이 ball일때 231, 312, 321
		for(int i =1; i<10 ; i++) {			
			if(check(i,shot[0],shot[2])) {
				bc.add(i*100+shot[2]*10+shot[0]);
				bc.add(shot[2]*100+shot[0]*10+i);
				bc.add(shot[2]*100+i*10+shot[0]);
			}
		}
		
		return bc;
	}
	
	private ArrayList<Integer> getBall3Case(){
		ArrayList<Integer> bc = new ArrayList<Integer>();
		
		bc.add(shot[2]*100 + shot[0]*10 + shot[1]);
		bc.add(shot[1]*100 + shot[2]*10 + shot[0]);
		return bc;
	}
	
	private int[] setShot(int shot) {
		int[] result = new int[3];
		char arr[] = Integer.toString(shot).toCharArray();
		
		for(int i=0; i<3; i++) {
			result[i] = arr[i] - '0';
		}
		return result;
	}
	
	private boolean check(int a, int b, int c) {		//진짜로 아 멈출수가없다 ㅋㅋㅋㅋㅋㅋㅋㅋ
		boolean x,y,z;					//중복되지않는 숫자기때문에 확인하는거 ㅋㅋㅋㅋ
		x = a==b ? false:true;
		y = b==c ? false:true;
		z = a==c ? false:true;
		return x&&y&&z;
	}
	
	public void printCases() {
		for(int i: cases) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

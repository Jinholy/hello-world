import java.io.PrintWriter;
import java.util.ArrayList;

public class Sudoku {
	private int[][] plate;
	private boolean[] nSets;
	private ArrayList<Integer>[][] candidates;
	
	public Sudoku() {
		plate = new int[9][9];
		nSets = new boolean[9];
		
		candidates = new ArrayList[9][9];
		
		for(int i=0; i<9; i++) {			//그짝에 들어갈수 있는 숫자 후보들
			for(int j=0; j<9; j++) {
				candidates[j][i] = new ArrayList<Integer>();
			}
		}
	}
	
	
	public void setPlate(String input){
		String nums[] = input.split("\n");
		
		char num[] = null;
		for(int i=0; i<9; i++) {
			num = nums[i].toCharArray();
			for(int j=0; j<9; j++) {
				plate[i][j] = num[j]-'0';
			}
		}
	}
	
	public void setPlateLine(int i, String nums) {
		char num[] =nums.toCharArray();
		
		for(int j=0; j<9; j++) {
			plate[i][j]= num[j]-'0';
		}
	}
	
	
	public void printPlate() {

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(" " +plate[i][j]);
				if((j+1)%3==0)
					System.out.print("|");
			}
			System.out.println();
			if((i+1)%3==0)
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
	}
	
	public void solve() {
		
	}
	
	public boolean checkRow(int i) {		//가로검사
		resetNSets();
		int num=0;
		for(int k=0; k<9; k++) {
			num = plate[i][k]-1;
			if(num!=-1)
				nSets[num] = true;
		}
		
		return checkNSets();
	}
	
	public boolean checkCol(int j) {		//세로검사
		resetNSets();

		int num=0;
		for(int k=0; k<9; k++) {
			num = plate[k][j]-1;
			if(num!=-1)
				nSets[num] = true;
		}
		
		return checkNSets();
	}
	
	public boolean checkBlock(int i, int j) {		//j=x, y=i 블럭검사
		resetNSets();
		
		int num=0;
		for(int k =i; k<i+3; k++) {
			for(int w=j; w<j+3; w++) {
				num = plate[w][k]-1;
				if(num!=-1)
					nSets[num] = true;
			}
		}
		return checkNSets();
	}
	
	public void resetNSets() {
		for(int i=0; i<9; i++)
			nSets[i] = false;
	}
	
	public boolean checkNSets() {
		int count =0;
		for(int i=0; i<9; i++) {
			if(nSets[i])
				count++;
		}
		if(count==9)
			return true;
		else
			return false;
	}
	
	
	public void setCandidate(int i, int j) {
		resetNSets();
		checkRowForCandidate(i);
		checkColForCandidate(j);
		checkBlockForCandidate(getBlockNum(i, j));

		for(int k=0; k<9; k++) {
			if(!nSets[k] && plate[j][i]==0)			//그 숫자가 없어야 후보가됨
				candidates[j][i].add(k+1);			
		}
	}
	
	public void setCandidates() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				setCandidate(i,j);
			}
		}
	}
	
	public void printCandidates() {
		try {
			PrintWriter out = new PrintWriter("debug.txt");
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
						out.print(i+","+j+": ");
						for(int k: candidates[j][i]) {
							out.print(k+" ");
						}
						out.println();	
				}
			}
			out.close();
		}catch(Exception e) {
			
		}
	}
	
	public void delCandidate(int i, int j, int num) {
		
	}
	
	public void checkRowForCandidate(int i) {		//후보될놈들 resetNSets()가없음
		int num=0;
		for(int k=0; k<9; k++) {
			num = plate[i][k]-1;
			if(num!=-1)
				nSets[num] = true;
		}
	}
	
	public void checkColForCandidate(int j) {		//세로검사
		int num=0;
		for(int k=0; k<9; k++) {
			num = plate[k][j]-1;
			if(num!=-1)
				nSets[num] = true;
		}
	}
	
	public void checkBlockForCandidate(int block) {		//j=x, y=i 블럭검사
		int num=0;
		int i = getBlockXdot(block);
		int j = getBlockYdot(block);
		
		for(int k =i; k<i+3; k++) {
			for(int w=j; w<j+3; w++) {
				num = plate[w][k]-1;
				if(num!=-1)
					nSets[num] = true;
			}
		}
	}
	
	public int getBlockNum(int i, int j) { //몇번째 블럭인지 체크하는거 왼쪽위부터 1~9
		int result =0;
		int x =	i/3;
		int y = i/3;
		
		if(x==0) {
			if(y==0) 		result = 1;	
			else if(y==1)	result = 4;
			else 			result = 7;
		}else if(x==1) {
			if(y==0) 		result = 2;	
			else if(y==1)	result = 5;
			else 			result = 8;
		}else{
			if(y==0) 		result = 3;	
			else if(y==1)	result = 6;
			else 			result = 9;
		}
		
		return result;
	}
	
	public int getBlockXdot(int x) {
		int result =0;
		switch(x) {
		case 1: result = 0; break;
		case 2: result = 3; break;
		case 3: result = 6; break;
		}
		return result;
	}
	public int getBlockYdot(int y) {
		int result =0;
		switch(y) {
		case 1: result = 0; break;
		case 2: result = 3; break;
		case 3: result = 6; break;
		}
		return result;
	}
}

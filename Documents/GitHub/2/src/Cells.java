
public class Cells {
	private int cells[][];
	private int n;		
	private int size;		//�迭ũ��� N+2�μ����� �迭ũ�����°� ����¯���ڳ�
	private int tGen[][];
	
	public Cells(int n) {
		this.n = n;
		this.size = n+2;
		
		cells = new int[size][size];
		tGen  = new int[size][size];
		for(int i =0; i<size; i++) {
			cells[i][0] =3;		//��谪����, 3����ǥ��
			cells[i][size-1] =3;
		}
		for(int i =0; i<size; i++) {
			cells[0][i] =3;		//��谪����, 3����ǥ��
			cells[size-1][i] =3;
		}


	}
	
	public void printCellsWithBoundary() {
		for(int i =0; i< size; i++) {
			for(int j=0; j< size; j++) {
				System.out.printf("%d",cells[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printCells() {
		for(int i =1; i< size-1; i++) {
			for(int j=1; j< size-1; j++) {
				System.out.printf("%d",cells[i][j]);
			}
			System.out.println();
		}
	}
	
	public void run() {
		for(int i=0; i< n; i++)		//n���� ����
			runGenerations();
	}
	public void runGenerations() {
		copyCells();		//�������븦 �ϴ� tGen�� ������
		
		for(int i=1; i<size-1; i++) {
			for(int j=1; j<size-1; j++) {
				cells[i][j]=isAlive(j,i);
			}
			System.out.println();
		}

		printCells();
	}
	
	public void inputCellStatus(int x, int y) {
		if(x<0 || y<0 || x >= size-2 || y >= size-2) {
			System.out.println("out of boundary");
			return;	
		}
		
		cells[y+1][x+1] =1;
	}
	
	public int isAlive(int x, int y) {
		int count =0;
		for(int i=y-1; i<y+2; i++) {
			for(int j =x-1; j<x+2; j++) {
				if(tGen[i][j]==1)
					count++;
			}
		}
		if(tGen[y][x]==1)
			count--;
		
		if(count ==3) {
			return 1;				//1�̸� ��Ƴ�
		}else if(count ==2){
			return tGen[y][x];	//2������
		}else {
			return 0;				//�̿ܿ� ����
		}
	}
	
	private void copyCells() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				tGen[j][i] = cells[j][i];
			}
		}
	}
}

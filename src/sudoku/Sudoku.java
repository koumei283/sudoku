package sudoku;

public class Sudoku {
public int[][] board= new int[9][9];

	public boolean check_row(int n, int x) {
		for(int i=0;i<9;i++) {
			if(board[x][i]==n) {
				return false;
			}
		}
		return true;
	}

	public boolean check_column(int n, int y) {
		for(int i=0;i<9;i++) {
			if(board[i][y]==n) {
				return false;
			}
		}
		return true;
	}

	public boolean check_group(int n, int x, int y) {
		int X=(x/3)*3;
		int Y=(y/3)*3;

		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[X+i][Y+j]==n) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean check(int n, int x, int y) {
		return (check_row(n, x))&&(check_column(n, y))&&(check_group(n, x, y));
	}

	public void solver(int n) {
		if(n==81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
		else {
			int x=n%9;
			int y=n/9;
			if(board[x][y]!=0) {
				solver(n+1);
			}
			else {
				for(int i=1;i<=9;i++) {
					if(check(i, x, y)) {
						board[x][y]=i;
						solver(n+1);
						board[x][y]=0;
					}
				}
			}
		}
	}


	public Sudoku() {
		// TODO 自動生成されたコンストラクター・スタブ
		solver(0);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//new Sudoku();
	}

}

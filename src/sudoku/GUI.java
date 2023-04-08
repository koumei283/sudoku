package sudoku;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	private JTextField[][] tf=new JTextField[9][9];
	private Button btn;
	private JPanel p1;
	private int[][] board=new int[9][9];

	public GUI() {
		// TODO 自動生成されたコンストラクター・スタブ
		setSize(500,500);
		btn=new Button("計算");
		p1=new JPanel();
		p1.setLayout(new GridLayout(9,9));
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				tf[i][j]=new JTextField(1);
				p1.add(tf[i][j]);
			}
		}
		btn=new Button("計算");
		btn.addActionListener(this);
		getContentPane().add(btn,"South");
		getContentPane().add(p1,"Center");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if((tf[i][j].getText())==null) {
					board[i][j]=0;
				}
				else {
					try {
						board[i][j]=Integer.parseInt(tf[i][j].getText());
					}catch(NumberFormatException f){
						System.out.println(tf[i][j].getText()+"は数値ではありません。");
					}
				}
			}
		}

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		solver(0);
	}
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
			new Display(board);
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


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new GUI();
	}
}

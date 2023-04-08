package sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JFrame{
	private JLabel[][] lbl=new JLabel[9][9];
	private JPanel p1;

	public Display(int[][] board) {
		// TODO 自動生成されたコンストラクター・スタブ
		setSize(500,500);
		p1=new JPanel();
		p1.setLayout(new GridLayout(9,9));
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				lbl[i][j]=new JLabel();
				lbl[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				lbl[i][j].setText(Integer.toString(board[i][j]));
				p1.add(lbl[i][j]);
				lbl[i][j].setHorizontalAlignment(JLabel.CENTER);
			}
		}
		getContentPane().add(p1,"Center");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener{
	
	Random random = new Random();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textLabel = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1Turn;
	
	TicTacToe(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLayout(new BorderLayout());
		
		textLabel.setBackground(new Color(25,25,25));
		textLabel.setForeground(new Color(25,255,0));
		textLabel.setFont(new Font("Chilanka",Font.BOLD,55));
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText("TicTacToe Game");
		textLabel.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(textLabel);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Chilanka",Font.BOLD,100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		
		this.add(buttonPanel);
		this.add(titlePanel,BorderLayout.NORTH);
		this.setVisible(true);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			if(e.getSource() == buttons[i]) {
				if(player1Turn) {
					if(buttons[i].getText().isBlank()) {
						buttons[i].setForeground(new Color(255,10,10));
						buttons[i].setText("X");
						player1Turn = false;
						textLabel.setText("O turn");
						check();
					}
				}
				else {
					if(!player1Turn) {
						if(buttons[i].getText().isBlank()) {
							buttons[i].setForeground(new Color(10,10,255));
							buttons[i].setText("O");
							player1Turn = true;
							textLabel.setText("X turn");
							check();
						}
					}
				}
			}
		}
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			player1Turn = true;
			textLabel.setText("X turn");
		}else {
			player1Turn = false;
			textLabel.setText("O turn");
		}
	}
	
	public void check() {
		
	}
	
	public void xWins(int a,int b, int c) {
		
	}
	
	public void oWins(int a,int b,int c) {
		
	}

}

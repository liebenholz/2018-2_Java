package w10.p9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvestmentViewer implements ActionListener{
	
	private static final int FRAME_WIDTH = 550; 
	private static final int FRAME_HEIGHT = 80;
	private static final double INITIAL_BALANCE = 1000.0;
	private static final double INTERSET_RATE = 10;
	final BankAccount account = new BankAccount(INITIAL_BALANCE);
	private JButton button = new JButton("Add Interest") ;
	private JLabel label = new JLabel("balance : " + account.getBalance());

	
	public InvestmentViewer() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		button.addActionListener(this);
		
		panel.add(button);	panel.add(label);
		frame.add(panel);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		double interest = account.getBalance() * INTERSET_RATE / 100;
		account.deposit(interest);
		label.setText("balance : " + account.getBalance());
	} 
	
	public static void main(String[] args) {
		new InvestmentViewer();
	}

}

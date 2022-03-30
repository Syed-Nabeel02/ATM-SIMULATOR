package atmPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Options extends JFrame implements ActionListener{
	
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton estatement;
	private JButton balance;
	private JButton backbutton;
	int GOLD = 0xFFD700;
	int PRUSSIANBLUE = 0x0B3C5D;
	//Deposit,Withdrawal,Esatement , Blance enquiry
	public Options() {
		
		//header
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Please chose the action you would like to perform");
		headerLabel.setForeground(new Color(GOLD));
		headerLabel.setFont(new Font("Rockwell",Font.PLAIN,30));
		headerLabel.setBounds(70, 20, 700, 50);
		
		//Deposit
		depositButton = new JButton("DEPOSIT");
		depositButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		depositButton.addActionListener(this);
		depositButton.setBackground(new Color(GOLD));
		depositButton.setFocusable(false);
		depositButton.setForeground(Color.black);
		depositButton.setBounds(175,200,200,75);
		
		//withdraw
		withdrawButton = new JButton("WITHDRAW");
		withdrawButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		withdrawButton.addActionListener(this);
		withdrawButton.setFocusable(false);
		withdrawButton.setBackground(new Color(GOLD));
		withdrawButton.setForeground(Color.black);
		withdrawButton.setBounds(425,200,200,75);
		
		//estatement
		estatement = new JButton("E-STATEMENT");
		estatement.setFont(new Font("Rockwell",Font.PLAIN,15));
		estatement.addActionListener(this);
		estatement.setBackground(new Color(GOLD));
		estatement.setFocusable(false);
		estatement.setForeground(Color.black);
		estatement.setBounds(175,300,200,75);
		
		balance = new JButton("BALANCE ENQUIRY");
		balance.setFont(new Font("Rockwell",Font.PLAIN,15));
		balance.addActionListener(this);
		balance.setBackground(new Color(GOLD));
		balance.setFocusable(false);
		balance.setForeground(Color.black);
		balance.setBounds(425,300,200,75);
		
		//withdraw
		backbutton = new JButton("BACK");
		backbutton.setFont(new Font("Rockwell",Font.PLAIN,15));
		backbutton.addActionListener(this);
		backbutton.setFocusable(false);
		backbutton.setBackground(new Color(GOLD));
		backbutton.setForeground(Color.black);
		backbutton.setBounds(300,400,200,75);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(800,600);
		this.getContentPane().setBackground(new Color(PRUSSIANBLUE));
		this.setResizable(false);
		this.add(headerLabel);
		this.add(depositButton);
		this.add(withdrawButton);
		this.add(estatement);
		this.add(balance);
		this.add(backbutton);
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backbutton) {
			new Login();
			this.dispose();
		}
		else if(e.getSource() == depositButton) {
			new Deposit();
			this.dispose();
		}
		else if(e.getSource() == withdrawButton) {
			new Withdraw();
			this.dispose();
		}
		else if(e.getSource() == balance) {
			String pin = JOptionPane.showInputDialog("Enter pin: ");
			int pinNo = Integer.parseInt(pin);
			
			Conn c1;
			try {
				c1 = new Conn();
				String q = "select * from bank where pinNo = '"+pinNo+"' order by idbank desc limit 1";
				ResultSet rs = c1.s.executeQuery(q);
				
				if(rs.next()) {
					Double balance = rs.getDouble("balance");
					JOptionPane.showMessageDialog(null, "Your balance is "+ balance);
				}
				else {
					JOptionPane.showMessageDialog(null, "incorrect details given");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	
}

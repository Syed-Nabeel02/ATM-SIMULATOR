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
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener{

	int GOLD = 0xFFD700;
	int PRUSSIANBLUE = 0x0B3C5D;
	
	JButton backButton;
	JButton withdrawButton;
	JTextField pinNoTf;
	JTextField withdraw;
	
	Withdraw(){
		JLabel pinLabel = new JLabel();
		pinLabel.setText("ENTER PIN:");
		pinLabel.setFont(new Font("Hack",Font.PLAIN,15));
		pinLabel.setForeground(new Color(GOLD));
		pinLabel.setBounds(690,10,100,60);
		
		pinNoTf = new JTextField();
		pinNoTf.setBounds(690,60,90,20);
		pinNoTf.setFont(new Font("Hack",Font.PLAIN,20));
		pinNoTf.setForeground(new Color(PRUSSIANBLUE));
		
		withdraw = new JTextField();
		withdraw.setBounds(250,270,300,40);
		withdraw.setFont(new Font("Hack",Font.PLAIN,20));
		withdraw.setForeground(new Color(PRUSSIANBLUE));
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		backButton.addActionListener(this);
		backButton.setBackground(new Color(GOLD));
		backButton.setForeground(Color.black);
		backButton.setBounds(250,380,120,50);
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		withdrawButton.addActionListener(this);
		withdrawButton.setBackground(new Color(GOLD));
		withdrawButton.setForeground(Color.black);
		withdrawButton.setBounds(445,380,120,50);
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("HOW MUCH WOULD YOU LIKE");
		headerLabel.setFont(new Font("Hack",Font.PLAIN,30));
		headerLabel.setForeground(new Color(GOLD));
		headerLabel.setBounds(190,100,500,60);
		
		JLabel headerLabel2 = new JLabel();
		headerLabel2.setText("TO WITHDRAW");
		headerLabel2.setFont(new Font("Hack",Font.PLAIN,30));
		headerLabel2.setForeground(new Color(GOLD));
		headerLabel2.setBounds(300,150,500,60);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(800,600);
		this.getContentPane().setBackground(new Color(PRUSSIANBLUE));
		this.setResizable(false);
		this.add(pinLabel);
		this.add(pinNoTf);
		this.add(withdraw);
		this.add(headerLabel);
		this.add(headerLabel2);
		this.add(backButton);
		this.add(withdrawButton);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pinNo2 = pinNoTf.getText();
		String withdrawA2 = withdraw.getText();

		if(e.getSource() == withdrawButton) {
			if(withdrawA2.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
			}
			else if(e.getSource() == withdrawButton && pinNo2.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter pin no.");
			}
			
			else if(e.getSource() == backButton) {
				this.dispose();
				new Options();
			}

		}
		try {
			int pinNo = Integer.parseInt(pinNo2);
			Double withdrawA = Double.parseDouble(withdrawA2);
			Double deposit = 0.0;

			Conn c1 = new Conn();
			String q = "select * from bank where pinNo = '"+pinNo+"' order by idbank desc limit 1";
			ResultSet rs = c1.s.executeQuery(q);

			if(rs.next()) {
				pinNo = rs.getInt("pinNo");
				Double balance = rs.getDouble("balance");
				balance -= withdrawA;

				if(balance < 0) {
					JOptionPane.showMessageDialog(null,"Not enough balance availble to withdraw this amount");
					this.dispose();
					new Options();

				}
				else {
					String q1 = "insert into bank (pinNo, deposit, withdraw, balance) values ('"+pinNo+"','"+deposit+"','"+withdrawA+"','"+balance+"')";
					c1.s.executeUpdate(q1);

					JOptionPane.showMessageDialog(null,  withdrawA + " has been succesfully withdrawn");
					this.dispose();
					new Options();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "incorrect details given");
			}
		}

		catch (SQLException e1) {
			System.out.println(e1);
		}

	}

}



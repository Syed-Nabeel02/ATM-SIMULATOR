package atmPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	int GOLD = 0xFFD700;
	int PRUSSIANBLUE = 0x0B3C5D;
	JTextField CardNoTf;
	JTextField PinNoTf;
	
	JButton signUpButton;
	JButton loginButton;
	
	Login(){
		
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Welcome to xyz ATM");
		headerLabel.setForeground(new Color(GOLD));
		headerLabel.setFont(new Font("Rockwell",Font.PLAIN,40));
		headerLabel.setBounds(200,50,400,60);
		
		JLabel CardNoLabel = new JLabel();
		CardNoLabel.setText("Enter Card No. : ");
		CardNoLabel.setForeground(new Color(GOLD));
		CardNoLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		CardNoLabel.setBounds(100,250,400,60);
		
		CardNoTf = new JTextField();
		CardNoTf.setBounds(275,250,400,50);
		CardNoTf.setFont(new Font("Rockwell",Font.PLAIN,20));
		
		
		
		JLabel PinNoLabel = new JLabel();
		PinNoLabel.setText("Enter Pin No. : ");
		PinNoLabel.setForeground(new Color(GOLD));
		PinNoLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		PinNoLabel.setBounds(100,350,400,60);
		
		PinNoTf = new JTextField(4);
		PinNoTf.setBounds(275,350,400,50);
		PinNoTf.setFont(new Font("Rockwell",Font.PLAIN,20));
		
		
		signUpButton = new JButton("Sign-Up");
		signUpButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		signUpButton.addActionListener(this);
		signUpButton.setBackground(new Color(GOLD));
		signUpButton.setForeground(Color.black);
		signUpButton.setBounds(280,450,100,50);
		
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Rockwell",Font.PLAIN,15));
		loginButton.addActionListener(this);
		loginButton.setBackground(new Color(GOLD));
		loginButton.setForeground(Color.black);
		loginButton.setBounds(580,450,100,50);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(800,600);
		this.getContentPane().setBackground(new Color(PRUSSIANBLUE));
		this.setResizable(false);
		this.add(headerLabel);
		this.add(CardNoLabel);
		this.add(CardNoTf);
		this.add(PinNoLabel);
		this.add(PinNoTf);
		this.add(signUpButton);
		this.add(loginButton);
		this.setVisible(true);

		

}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if(e.getSource() == signUpButton) {
				this.dispose();
				new Signup();
				System.out.println("hi");
			}
			else if(e.getSource() == loginButton) {
				Conn c1 = new Conn();
				String a = CardNoTf.getText();
				String b = PinNoTf.getText();
				String q = "select * from login where cardNo = '"+a+"'and pinNo = '"+b+"'";
				ResultSet rs = c1.s.executeQuery(q);
				
				if(rs.next()) {
				new Options();
				this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "incorrect details given");
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}
}

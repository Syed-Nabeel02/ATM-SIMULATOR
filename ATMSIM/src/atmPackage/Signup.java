package atmPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Signup extends JFrame implements ActionListener{
	int GOLD = 0xFFD700;
	int PRUSSIANBlUE = 0x0B3C5D;
	int STEEL = 0x0A1612;
	int cardNo;
	int pinNo;
	
	JTextField nameTextField;
	JTextField ageTextField;
	
	JPanel middle;
	
	JButton submitButton = new JButton("Submit");;
	JButton returnButton;
	JTextField addressTextField;
	JTextField sinNumberTextField;
	JCheckBox checkBox;
	JRadioButton checkingAccount;
	JRadioButton savingsAccount;
	
	Signup(){
		//Border
		Border border = BorderFactory.createLineBorder(new Color(STEEL),3);
		
		//Header Label
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Page 1: Enter Personal Details");
		headerLabel.setForeground(new Color(GOLD));
		headerLabel.setFont(new Font("Rockwell",Font.PLAIN,40));
		headerLabel.setVerticalAlignment(JLabel.CENTER);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		//Header Panel
		JPanel header = new JPanel();
		header.setBackground(new Color(PRUSSIANBlUE));
		header.setPreferredSize(new Dimension(100,100));
		header.add(headerLabel); 
		
		//nameLabel
		JLabel nameLabel = new JLabel();
		nameLabel.setText("1) Enter Full Name: ");
		nameLabel.setForeground(new Color(GOLD));
		nameLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		nameLabel.setBounds(90,50,400,50);
		//ageLabel
		JLabel ageLabel = new JLabel();
		ageLabel.setText("2) Enter Age: ");
		ageLabel.setForeground(new Color(GOLD));
		ageLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		ageLabel.setBounds(90,125,400,50);
		//address Label
		JLabel addressLabel = new JLabel();
		addressLabel.setText("3) Enter Address PO.Box: ");
		addressLabel.setForeground(new Color(GOLD));
		addressLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		addressLabel.setBounds(90,200,400,50);
		//sinNumber Panel
		JLabel sinNumberLabel = new JLabel();
		sinNumberLabel.setText("4) Enter SinNumber: ");
		sinNumberLabel.setForeground(new Color(GOLD));
		sinNumberLabel.setFont(new Font("Rockwell",Font.PLAIN,20));
		sinNumberLabel.setBounds(90,275,400,50);
		
		JLabel whichAccount = new JLabel();
		whichAccount.setText("5) What type of Account would you like to choose ?");
		whichAccount.setForeground(new Color(GOLD));
		whichAccount.setFont(new Font("Rockwell",Font.PLAIN,20));
		whichAccount.setBounds(90,350,700,50);
		
		//nametextfied
		nameTextField = new JTextField();
		nameTextField.setForeground(new Color(GOLD));
		nameTextField.setFont(new Font("Rockwell",Font.PLAIN,20));
		nameTextField.setBackground(Color.white);
		nameTextField.setBounds(375,55,400,35);
		//AgeTextField
		ageTextField = new JTextField();
		ageTextField.setPreferredSize(new Dimension(400,50));
		ageTextField.setForeground(new Color(GOLD));
		ageTextField.setFont(new Font("Rockwell",Font.PLAIN,20));
		ageTextField.setBackground(Color.white);
		ageTextField.setBounds(375,130,400,35);
		//address textField
		addressTextField = new JTextField();
		addressTextField.setPreferredSize(new Dimension(400,50));
		addressTextField.setForeground(new Color(GOLD));
		addressTextField.setFont(new Font("Rockwell",Font.PLAIN,20));
		addressTextField.setBackground(Color.white);
		addressTextField.setBounds(375,205,400,35);
		//sinNumber TextField
		sinNumberTextField = new JTextField();
		sinNumberTextField.setPreferredSize(new Dimension(400,50));
		sinNumberTextField.setForeground(new Color(GOLD));
		sinNumberTextField.setFont(new Font("Rockwell",Font.PLAIN,20));
		sinNumberTextField.setBackground(Color.white);
		sinNumberTextField.setBounds(375,280,400,35);
		
		//JRadio button
		checkingAccount = new JRadioButton("Checking Account");
		checkingAccount.setForeground(new Color(GOLD));
		checkingAccount.setFont(new Font("Rockwell",Font.PLAIN,20));
		checkingAccount.setBounds(90,425,200,20);
		checkingAccount.setOpaque(false);
		
		savingsAccount = new JRadioButton("Savings Account");
		savingsAccount.setFont(new Font("Rockwell",Font.PLAIN,20));
		savingsAccount.setBounds(90,450,200,20);
		savingsAccount.setForeground(new Color(GOLD));
		savingsAccount.setOpaque(false);
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(checkingAccount);
		group.add(savingsAccount);
		
		checkBox = new JCheckBox("I herby declare all information provided here is true and correct");
		checkBox.setForeground(new Color(GOLD));
		checkBox.setFont(new Font("Rockwell",Font.PLAIN,20));		
		checkBox.setBounds(90,500,700,200);
		checkBox.setOpaque(false);
		
		//Middle panel
		middle = new JPanel();
		middle.setLayout(null);
		middle.setBackground(new Color(PRUSSIANBlUE));
		middle.add(nameLabel);
		middle.add(ageLabel);
		middle.add(addressLabel);
		middle.add(sinNumberLabel);
		middle.add(nameTextField);
		middle.add(ageTextField);
		middle.add(addressTextField);
		middle.add(sinNumberTextField);
		middle.add(whichAccount);
		middle.add(checkingAccount);
		middle.add(savingsAccount);
		middle.add(checkBox);
		//right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(PRUSSIANBlUE));
		rightPanel.setPreferredSize(new Dimension(20,0));
		//Left Panel 
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(PRUSSIANBlUE));
		leftPanel.setPreferredSize(new Dimension(20,20));
		
		//Submit
		submitButton.setBackground(new Color(GOLD));
		submitButton.setVerticalAlignment(JButton.CENTER);
		submitButton.setHorizontalAlignment(JButton.CENTER);
		submitButton.addActionListener(this);
		submitButton.setFocusable(false);
		submitButton.setBounds(700,20,100,50); 
		
		//reeturn
		returnButton = new JButton("Back");
		returnButton.setBackground(new Color(GOLD));
		returnButton.setVerticalAlignment(JButton.CENTER);
		returnButton.setHorizontalAlignment(JButton.CENTER);
		returnButton.setFocusable(false);
		returnButton.addActionListener(this);
		returnButton.setBounds(75,20,100,50); 
		//JPanel footer
		JPanel footer = new JPanel();
		footer.setPreferredSize(new Dimension(0,100));
		footer.setBackground(new Color(PRUSSIANBlUE)); //Neutral
		footer.setLayout(null);
		footer.add(submitButton);
		footer.add(returnButton);
		
		Random rnd = new Random();
	    cardNo = rnd.nextInt(9999);
	    pinNo = rnd.nextInt(9999);
		
		//Main Container
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(900,1000);
		this.setVisible(true);
		this.setResizable(false);
		this.add(header,BorderLayout.NORTH);
		this.add(middle,BorderLayout.CENTER);
		this.add(rightPanel,BorderLayout.EAST);
		this.add(leftPanel,BorderLayout.WEST);
		this.add(footer,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(e.getSource() == submitButton && !checkBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please check the check box","",JOptionPane.PLAIN_MESSAGE);
			
		}
			else if(e.getSource() == returnButton) {
				this.dispose();
				Login frame = new Login();
			}
			else if(e.getSource() == submitButton) {
				Conn c1 = new Conn();
				int pNo = pinNo;
				int cNo = cardNo;
				Double deposit = 0.0;
				Double balance = 0.0;
				Double withdraw = 0.0;
				String a = nameTextField.getText();
				String b = ageTextField.getText();
				String c = addressTextField.getText();
				String d = sinNumberTextField.getText();
				String type;
					if(checkingAccount.isSelected()) {
						type = "checking account";
					}
					else {
						type = "savings Account";
					}
				String q = "insert into login values ('"+pNo+"','"+cNo+"','"+a+"','"+b+"','"+c+"','"+d+"','"+type+"')";
				c1.s.executeUpdate(q);
				
				String p = "insert into bank (pinNo, deposit, withdraw, balance) values ('"+pNo+"','"+deposit+"','"+withdraw+"','"+balance+"')";
				c1.s.executeUpdate(p);
				
				JOptionPane.showMessageDialog(null, "Your last 4 cardNo digits are : " + cNo+"\n Yor pinNo is "+pNo);
				new Login();
				this.dispose();
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

}

package atmPackage;

import java.util.Random;

public class Accounts {
	
	private int pinNo;
	private int cardNo;
	private String fullName;
	private int age;
	private String address;
	private String sinNumber;
	private String type;
	
	private String[] eStatement;
	private double balance;
	private String transaction;
	private int not;
	private double transactionAmount;
	Random rnd = new Random();
	
	public Accounts(String fullName, int age, String address, String sinNumber,String type) {
		this.fullName = fullName;
		this.age = age;
		this.address = address;
		this.sinNumber = sinNumber;
		this.not = 0;
		this.balance = 0;
		this.eStatement = new String[100];	
		this.pinNo = rnd.nextInt(9999);
		
		this.cardNo = rnd.nextInt(900000000);
		
	}

	public int getPinNo() {
		return pinNo;
	}
	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}

	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	
	public void deposit(double x) {
		this.balance+=x;
		this.not++;
	}
	
	public void withdraw(double x) {
		if(this.balance <= x) {
			//throw exception
		}
		
		else {
			this.balance -= x;
			this.not++;
		}
	}
	
	public void doTransaction(String transaction , double transactionAmount) {
		this.transactionAmount = transactionAmount;
		
		if(this.transaction.equals("deposit")) {
			this.deposit(transactionAmount);
		}
		else if(this.transaction.equals("withdraw")) {
			this.withdraw(transactionAmount);
		}
	
		this.eStatement[this.not] = String.format("Transaction No.: %d | %s Amount: %d | Balance: %d \n"
				,this.not,this.transaction,this.transactionAmount,this.balance);
		
		this.transactionAmount = 0;
	}
	
	public String displayEstatement() {
		String eStatementString = "";
		for(int i = 0; i<this.not;i++) {
			eStatementString += this.eStatement[i];
			
		}
		
		
		return eStatementString;
	}
	

}

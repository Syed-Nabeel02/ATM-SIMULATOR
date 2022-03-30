package atmPackage;

public class Bank {
	
	private Accounts [] accountArr;
	private int noa;
	private int maxNumberOfAccounts;
	
	Bank(){
		this.maxNumberOfAccounts = 100;
		this.noa = 0;
		this.accountArr = new Accounts[100];
	}
	
	public void addAcount(String fullName, int age, String address, String sinNumber,String type) {
		Accounts a = new Accounts(fullName,age,address,sinNumber,type);
		this.accountArr[this.noa] = a;
	}
	
	public Accounts getAccount(int cardNo, int pin) {
		for(int i =0; i< this.noa;i++) {
			if(this.accountArr[i].getCardNo() == cardNo &&
					this.accountArr[i].getPinNo() == pin) {
				return this.accountArr[i];
			}
		}
		return null;
	}
	
	
}

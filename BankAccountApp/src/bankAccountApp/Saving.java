package bankAccountApp;

public class Saving extends Account {

	// List properties specific to the Saving account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;

	// Constructor to initialize setting for the Saving properties
	public Saving(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();

	}

	@Override
	public void setRate() {
		rate = getBaseRate() - .25;

	}

	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));

	}
	// List any methods specific to saving account

	public void showInfo() {
		super.showInfo();
		System.out.println(" Your Saving Account Features" + "\n Safety Deposit Box ID: " + safetyDepositBoxID
				+ "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
		;

	}

}

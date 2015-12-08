/**This is an instantiable User class.
 @author Peter Mikulasko
 @version 1.0 */ 

import java.io.*;
public class User implements Serializable {
	
	private String accName;
	private float balance = 0;
	
	
	/** no argument constructor method
	 @param name the full name of the student */
	public User() {
		this("not Set");
	}
	
	/** single argument constructor method
	 @param accName the account name of the user */	
	public User(String accName) {
		this.accName = accName;
	}
	
	
	/** mutator method to set the account name
	 *@param accName the account name of the user */	
	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	
	/** acessor method to return the user's account name
	 *@return the account name of the user */
	public String getAccountName() {
		return accName;
	}
	
	
	/** acessor method to return the user balance
	 *@return the balance of the user */	
	public float getBalance() {
		return balance;
	}
	
	/** mutator method to set the user balance
	 *@param balance the balance of the user */
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
	/** topUp method to set/topup user balance
	 *@param amount the amount to topup */	
	public void topUp(float amount) {
		balance += amount;
	}
	
	/** toString method to return the user details
	 *@return the account name and balance of the user as a string */	
	public String toString() {
		return "Account Name: " + getAccountName() + ", " +
				"Your Balance is "+ getBalance();
	}
	
}
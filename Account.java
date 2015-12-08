import java.io.*;
public class Account implements Serializable  {
	private User user;
	private int AccNo;
	private static int accountStartNum = 80000000;
	
	public Account() {
		accountStartNum++;
		AccNo=accountStartNum;
		user = new User();
		
	}
	
	public Account(String accName) {
		accountStartNum++;
		AccNo=accountStartNum;
		user = new User(accName);
	}
	
	public int getAccNo() {
		return AccNo;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public String toString() {
		return "Account Name: " + user.getAccountName() +  "\n" +
				"Account Number: " + getAccNo();
	}
	
}
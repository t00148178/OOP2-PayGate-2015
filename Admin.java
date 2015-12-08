import javax.swing.JOptionPane;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Admin {
	
	static Account acc;
			
	static List<Account> accounts = new LinkedList<Account>();
	
	public  static void createAccount() {		
		String accountName = JOptionPane.showInputDialog("enter Account Name for  Account: ");			
		
		acc = new Account(accountName);				
		accounts.add(acc);    

        for (int i = 0; i<accounts.size(); i++){
            acc = accounts.get( i);
            
            System.out.println(acc.toString());
            JOptionPane.showMessageDialog(null, acc.toString());
        }  	    
	}
	
	public static void setAccounts(List<Account> list)
	{
		accounts = list;
	}
	
	public static List<Account> getAccounts()
	{
		return accounts;
	}
	
	public static void saveAccounts() throws Exception {
		JOptionPane.showMessageDialog(null, "saving...");
	    ObjectOutputStream os;
	    os = new ObjectOutputStream(new FileOutputStream ("accounts.dat"));
	    os.writeObject(accounts);
	    JOptionPane.showMessageDialog(null, "saved");
	    os.close();  
	}	
}


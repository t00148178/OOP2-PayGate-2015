import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class PayGateApp extends JFrame implements ActionListener {
	
	private JMenuBar jMenuBar;
	private JMenu fileMenu,accountMenu;
	private JMenuItem quit,save,open,sendMoney,requestMoney,depositMoney;
	private JButton depositButton;
	private JLabel initMessage; 		
	private JTextField jTextField;		
	private static Container cp;
	private static JTextArea accDetailsResult;		
	private static JLabel initAccName;			
	private static String message;	
	
	static Admin admin;	
	static Account useracc;
	
	static ArrayList<User> users = new ArrayList<User>();
	static List<Account> accounts = Admin.getAccounts();

	public static void main(String[] args)  {			
		Object[] options = {"Admin","User"};
			int n = JOptionPane.showOptionDialog(null,"Enter admin or user?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
			    null,options,options[0]); 		
			if(n==0) {			
				adminJFrame();
				try {
					createAccount();
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
			if(n==1) {				
				try {
					openAccounts();
					
					message = displayInitMessage();
					initAccName = new JLabel();					
					initAccName.setVisible(true);

					accDetailsResult = new JTextArea("message: ",5, 20);
					accDetailsResult.setVisible(true);
					accDetailsResult.setEditable(false);
					accDetailsResult.append(message);
				} catch (Exception e) {
					e.printStackTrace();
				}				
				PayGateApp app = new PayGateApp();
				app.setVisible(true);					
			}		
	}
	
	public PayGateApp() {		
		super("PayGate");
		setSize(450,550);
		setResizable(false);
		setLocation(600,300);
		
		cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		fileMenu();
		accountMenu();
		
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		initAccName = new JLabel("texdd");
		cp.add(initAccName);
		initAccName.setVisible(false);
		
		accDetailsResult = new JTextArea();
		cp.add(accDetailsResult);
		accDetailsResult.setVisible(false);
		
		jMenuBar.add(fileMenu);
		jMenuBar.add(accountMenu);	
		
		jTextField = new JTextField(5);
		this.setVisible(false);
		
		initAccName = new JLabel("account deatils");
		cp.add(initAccName);
		
		depositButton = new JButton();
		depositButton.setVisible(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		Account acc;			
		
		Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            acc = iterator.next();
            System.out.print(acc.getAccNo());
        } 	
	}
	
	public static void openAccounts() throws Exception {
	    ObjectInputStream ois;
	    ois = new ObjectInputStream(new FileInputStream ("accounts.dat"));
	    
	    Account acc;	    
	    accounts = (LinkedList<Account>) ois.readObject();
	    Admin.setAccounts(accounts);
	    
	    Iterator<Account> it = accounts.iterator();
	    Account selectedAccount;
	    Boolean found = false;
	    	    
	    String searchAcc= JOptionPane.showInputDialog("Account name: ");
	    while(it.hasNext()&&!found) {
	    	selectedAccount=it.next();
	    	
	    	if(selectedAccount.getUser().getAccountName().equals(searchAcc)){
	    		useracc=selectedAccount;
	    		found = true;
	    		
	    		System.out.println(useracc.getUser().getAccountName()+ ": " + found);
	    		
	    	} else {
	    		System.out.println("Account not found");
	    	}	    	    
	    }
	    ois.close();  
	        
	}	
		
	public static String displayInitMessage() {		
		String userName = useracc.getUser().getAccountName();
		float userBalance = useracc.getUser().getBalance();
	
		int userAccNumber = useracc.getAccNo();
		
		
		
		if(userBalance <= 0) {
			String message = "Account Name: " + userName + "\n" +
							 "Account Number: " + userAccNumber + "\n" +
							 "Balance: " + userBalance;
										 
		} else {
			JOptionPane.showMessageDialog(null,"0 on your account, deposit or request money");
		}		
		return message;
	}	
	
	public static void adminJFrame() {
		JFrame jFrame = new JFrame("Admin");		
		jFrame.setVisible(true);	
		jFrame.setSize(450,550);
		jFrame.setResizable(false);
		jFrame.setLocation(600,300);
		
		jFrame.getContentPane();
		jFrame.setLayout(new FlowLayout());
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void depositMoney(float amount) {		
		useracc.getUser().topUp(amount);
	}
	
	private static void createAccount(){		
		try {
			Admin.createAccount();
		} catch (Exception e1) {
			e1.printStackTrace();
		}				
		while(true) {		
			int optionResult = JOptionPane.showConfirmDialog(null,"Do you wish to enter more accounts?");	
			if(optionResult == JOptionPane.NO_OPTION || optionResult == JOptionPane.CANCEL_OPTION) {				
				try {
					Admin.saveAccounts();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			else
			{					
			   try {
				Admin.createAccount();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}	
		}			
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Quit")) {
			JOptionPane.showMessageDialog(null, "System exits");
			System.exit(0);
		} else if(e.getActionCommand().equals("Open")) {
			
		} else if(e.getActionCommand().equals("Save")) {
			
		} else if(e.getActionCommand().equals("Send Money")) {
			
		} else if(e.getActionCommand().equals("Request Money")) {
			
		} else if(e.getActionCommand().equals("Deposit Money")) {
			
			this.add(jTextField);
			this.setVisible(true);
			
			this.add(depositButton);
			depositButton.setText("Deposit");
			depositButton.setVisible(true);			
			
			depositButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 	 
			 
			    try {
			      int amount=Integer.parseInt(jTextField.getText());
			      System.out.println("amount is: "+amount);
			      
			      depositMoney(amount);
			     
			      System.out.println(useracc.getUser().getBalance() + " is new balance for user: ");
			      	System.out.println(useracc.getUser().getAccountName());
			      	System.out.println(useracc.getUser().getBalance());
			      	
			      	Admin.setAccounts(accounts);
					Admin.saveAccounts();
			    }
			    catch (NumberFormatException ex) {
			      System.out.println("Not a number");
			      
			   } catch (Exception e1) {					
					e1.printStackTrace();
				}	

				jTextField.setVisible(false);
				
				cp.add(depositButton);
				depositButton.setText("Deposit");
				depositButton.setVisible(true);					
				
				try {
					loadUser();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			  } 
			});		
			
		}  else {
			JOptionPane.showMessageDialog(null, "start by selecting menu");
		}
		
	}
	
	public static void loadUser() throws Exception {
		JOptionPane.showMessageDialog(null, "opening...");
	    ObjectInputStream ois;    
	    FileInputStream fis = new FileInputStream ("accounts.dat");	    
	    ois = new ObjectInputStream(fis);
	    	    
	    if(ois==null)
	    		System.out.println("ois is null");
	    
	    accounts = (LinkedList<Account>) ois.readObject(); 

	    for(int i=0;i<accounts.size();i++)
	    	if(accounts.get(i).getUser()==null)
	    		System.out.println("nothing in this slot of list");
	    	else
	    	    System.out.println("load user/display balance: " + accounts.get(i).getUser().getBalance());
	    	    
	    JOptionPane.showMessageDialog(null, "open");
	    ois.close();  
	    fis.close();
	}
	
	public static void saveUser() throws Exception {
		JOptionPane.showMessageDialog(null, "saving...");
	    ObjectOutputStream os;
	    FileOutputStream fos = new FileOutputStream ("user.dat");
	    os = new ObjectOutputStream(fos);
	    os.writeObject(users);
	    JOptionPane.showMessageDialog(null, "saved");
	    os.close();
	    fos.close();
	}
	
	private void fileMenu() {	
		fileMenu = new JMenu("File");		
		quit = new JMenuItem("Quit");
		quit.addActionListener(this);
		open = new JMenuItem("Open");
		open.addActionListener(this);
		save = new JMenuItem("save");
		save.addActionListener(this);
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(quit);				
	}
	
	private void accountMenu() {		
		accountMenu = new JMenu("Account");		
		sendMoney = new JMenuItem("Send Money");
		sendMoney.addActionListener(this);
		requestMoney = new JMenuItem("Request Money");
		requestMoney.addActionListener(this);
		depositMoney = new JMenuItem("Deposit Money");
		depositMoney.addActionListener(this);		
		
		accountMenu.add(sendMoney);
		accountMenu.add(requestMoney);	
		accountMenu.add(depositMoney);		
	}
}
